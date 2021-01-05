/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author fiz
 */
public class Peliculas implements Serializable{
      
        private String titulo;
        private int ano;
        private int duracion;
        private String pais;
        private List <String> direccion;
        private String guion;
        private String musica;
        private String fotografia;
        private List <String> reparto;
        private String productora;
        private String genero;
        private String sinopsis;
        
        public Peliculas(String titulo, int ano, int duracion, String pais, List<String> direccion,
                String guion, String musica, String fotografia, List<String> reparto,
                String productora, String genero, String sinopsis) {
        this.titulo = titulo;
        this.ano = ano;
        this.duracion = duracion;
        this.pais = pais;
        this.direccion = direccion;
        this.guion = guion;
        this.musica = musica;
        this.fotografia = fotografia;
        this.reparto = reparto;
        this.productora = productora;
        this.genero = genero;
        this.sinopsis = sinopsis;
    }
          
        
        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public int getAno() {
            return ano;
        }

        public void setAno(int ano) {
            this.ano = ano;
        }

        public int getDuracion() {
            return duracion;
        }

        public void setDuracion(int duracion) {
            this.duracion = duracion;
        }
        
        public String getPais() {
        return pais;
        }

        public void setPais(String pais) {
        this.pais = pais;
        }

        public List<String> getDireccion() {
            return direccion;
        }

        public void setDireccion(List<String> direccion) {
            this.direccion = direccion;
        }

        public String getGuion() {
            return guion;
        }

        public void setGuion(String guion) {
            this.guion = guion;
        }

        public String getMusica() {
            return musica;
        }

        public void setMusica(String musica) {
            this.musica = musica;
        }

        public String getFotografia() {
            return fotografia;
        }

        public void setFotografia(String fotografia) {
            this.fotografia = fotografia;
        }

        public List<String> getReparto() {
            return reparto;
        }

        public void setReparto(List<String> reparto) {
            this.reparto = reparto;
        }

        public String getProductora() {
            return productora;
        }

        public void setProductora(String productora) {
            this.productora = productora;
        }

        public String getGenero() {
            return genero;
        }

        public void setGenero(String genero) {
            this.genero = genero;
        }

        public String getSinopsis() {
            return sinopsis;
        }

        public void setSinopsis(String sinopsis) {
            this.sinopsis = sinopsis;
        }
        
        public String exportStateAsHTMLRow() {
            return String.format("<TR><TD>%s</TD><TD>%d</TD><TD>%d</TD><TD>%s</TD>"
                + "<TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD><TD>%s</TD>"
                + "<TD>%s</TD><TD>%s</TD><TD>%s</TD><TR>",
                this.titulo,
                this.ano,
                this.duracion,
                this.pais,
                String.join(", ", this.direccion),
                this.guion,
                this.musica,
                this.fotografia,
                String.join(", ", this.reparto),
                this.productora,
                this.genero,
                this.sinopsis);
    }
}
