/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagens;

/**
 *
 * @author Lucas
 */
public class Devolucao {
    private int id;
    private int aluno;
    private int livro1;
    private int livro2;
    private int multa;
    private String dataRealizacao;
    private String dataFinal;
    
    
    public Devolucao(){}
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the aluno
     */
    public int getAluno() {
        return aluno;
    }

    /**
     * @param aluno the aluno to set
     */
    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    /**
     * @return the livro1
     */
    public int getLivro1() {
        return livro1;
    }

    /**
     * @param livro1 the livro1 to set
     */
    public void setLivro1(int livro1) {
        this.livro1 = livro1;
    }

    /**
     * @return the livro2
     */
    public int getLivro2() {
        return livro2;
    }

    /**
     * @param livro2 the livro2 to set
     */
    public void setLivro2(int livro2) {
        this.livro2 = livro2;
    }

    /**
     * @return the multa
     */
    public int getMulta() {
        return multa;
    }

    /**
     * @param multa the multa to set
     */
    public void setMulta(int multa) {
        this.multa = multa;
    }

    /**
     * @return the data1
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the data1 to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return the data2
     */
    public String getDataFinal() {
        return dataFinal;
    }

    /**
     * @param dataFinal the data2 to set
     */
    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }
    
}
