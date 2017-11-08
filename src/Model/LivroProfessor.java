/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Lucas
 */
public class LivroProfessor {
    private int professorId;
    private int livroId;
    private String dataRealizacao;
    private String dataDevolucao;

    /**
     * @return the prof
     */
    public int getProfessorId() {
        return professorId;
    }

    /**
     * @param professorId the prof to set
     */
    public void setProfessorId(int professorId) {
        this.professorId = professorId;
    }

    /**
     * @return the liv
     */
    public int getLivroId() {
        return livroId;
    }

    /**
     * @param livroId the liv to set
     */
    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    /**
     * @return the data
     */
    public String getDataRealizacao() {
        return dataRealizacao;
    }

    /**
     * @param dataRealizacao the data to set
     */
    public void setDataRealizacao(String dataRealizacao) {
        this.dataRealizacao = dataRealizacao;
    }

    /**
     * @return the devlvido
     */
    public String isDevlvido() {
        return dataDevolucao;
    }

    /**
     * @param devlvido the devlvido to set
     */
    public void setDevlvido(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
    
}
