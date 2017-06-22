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

/**
 *  This class will change the bounds of the JComboBox popup menu to support
 *  different functionality. It will support the following features:
 *  -  a horizontal scrollbar can be displayed when necessary
 *  -  the popup can be wider than the combo box
 *  -  the popup can be displayed above the combo box
 *
 *  Class will only work for a JComboBox that uses a BasicComboPop.
 */
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

	protected void customizePopup(BasicComboPopup popup)
	{
		scrollPane = getScrollPane(popup);
                
                JList list = popup.getList();

		//  Determine the maximimum width to use:
		//  a) determine the popup preferred width
		//  b) limit width to the maximum if specified
		//  c) ensure width is not less than the scroll pane width

		int popupWidth = list.getPreferredSize().width
					   + 5  // make sure horizontal scrollbar doesn't appear
					   + getScrollBarWidth(popup, scrollPane);


		Dimension scrollPaneSize = scrollPane.getPreferredSize();
		popupWidth = Math.max(popupWidth, scrollPaneSize.width);

		//  Adjust the width

		scrollPaneSize.width = popupWidth;//aqui
		scrollPane.setPreferredSize(scrollPaneSize);
		scrollPane.setMaximumSize(scrollPaneSize);

		//  For some reason in JDK7 the popup will not display at its preferred
		//  width unless its location has been changed from its default
		//  (ie. for normal "pop down" shift the popup and reset)

		Component comboBox = popup.getInvoker();
		Point location = comboBox.getLocationOnScreen();


			int height = comboBox.getPreferredSize().height;
			popup.setLocation(location.x, location.y + height - 1);
			popup.setLocation(location.x, location.y + height);

	}



	

	/*
	 *  Get the scroll pane used by the popup so its bounds can be adjusted
	 */
	protected JScrollPane getScrollPane(BasicComboPopup popup)
	{
		JList list = popup.getList();
		Container c = SwingUtilities.getAncestorOfClass(JScrollPane.class, list);

		return (JScrollPane)c;
	}

	/*
	 *  I can't find any property on the scrollBar to determine if it will be
	 *  displayed or not so use brute force to determine this.
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

	/*
	 *  I can't find any property on the scrollBar to determine if it will be
	 *  displayed or not so use brute force to determine this.
	 */
	protected boolean horizontalScrollBarWillBeVisible(BasicComboPopup popup, JScrollPane scrollPane)
	{
		JList list = popup.getList();
		int scrollBarWidth = getScrollBarWidth(popup, scrollPane);
		int popupWidth = list.getPreferredSize().width + scrollBarWidth;

		return popupWidth > scrollPane.getPreferredSize().width;
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

