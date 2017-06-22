/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.plaf.basic.*;


public class BoundsPopupMenuListener implements PopupMenuListener
{

	private JScrollPane scrollPane;


	@Override
	public void popupMenuWillBecomeVisible(PopupMenuEvent e)
	{
		JComboBox comboBox = (JComboBox)e.getSource();

		if (comboBox.getItemCount() == 0) return;

		final Object child = comboBox.getAccessibleContext().getAccessibleChild(0);

		if (child instanceof BasicComboPopup)
		{
			SwingUtilities.invokeLater(new Runnable()
			{
				public void run()
				{
					customizePopup((BasicComboPopup)child);
				}
			});
		}
	}
        //ajusta a visão da lista
	protected void customizePopup(BasicComboPopup popup)
	{
		scrollPane = getScrollPane(popup);
                
                JList list = popup.getList();


		int popupWidth = list.getPreferredSize().width//tamanho da combobox
					   + 8  // segurança
					   + getScrollBarWidth(popup, scrollPane);


		Dimension scrollPaneSize = scrollPane.getPreferredSize();
		popupWidth = Math.max(popupWidth, scrollPaneSize.width);

		//  ajusta a largura

		scrollPaneSize.width = popupWidth;//aqui
		scrollPane.setPreferredSize(scrollPaneSize);
		scrollPane.setMaximumSize(scrollPaneSize);

		//coloca a lsita em baixo

		Component comboBox = popup.getInvoker();
		Point location = comboBox.getLocationOnScreen();


			int height = comboBox.getPreferredSize().height;
			popup.setLocation(location.x, location.y + height - 1);
			popup.setLocation(location.x, location.y + height);

	}



	

	//recupera as dimensões da combobox
	protected JScrollPane getScrollPane(BasicComboPopup popup)
	{
		JList list = popup.getList();
		Container c = SwingUtilities.getAncestorOfClass(JScrollPane.class, list);

		return (JScrollPane)c;
	}

	/*
	 *  ?
	 */
	protected int getScrollBarWidth(BasicComboPopup popup, JScrollPane scrollPane)
	{
		int scrollBarWidth = 0;
		JComboBox comboBox = (JComboBox)popup.getInvoker();

		if (comboBox.getItemCount() > comboBox.getMaximumRowCount())
		{
			JScrollBar vertical = scrollPane.getVerticalScrollBar();
			scrollBarWidth = vertical.getPreferredSize().width;
		}

		return scrollBarWidth;
	}

	

	@Override
	public void popupMenuCanceled(PopupMenuEvent e) {}

	@Override
	public void popupMenuWillBecomeInvisible(PopupMenuEvent e)
	{
		//  In its normal state the scrollpane does not have a scrollbar

		if (scrollPane != null)
		{
			scrollPane.setHorizontalScrollBar( null );
		}
	}
}

