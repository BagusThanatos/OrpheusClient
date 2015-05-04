/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package orpheusclient;

/**
 *
 * @author BagusThanatos (github.com/BagusThanatos)
 */
public class Album {
    String id_album,namaAlbum,tgl_rilis,artist;
    int harga;

    public Album(String id_album, String namaAlbum, String tgl_rilis, String artist, int harga) {
        this.id_album = id_album;
        this.namaAlbum = namaAlbum;
        this.tgl_rilis = tgl_rilis;
        this.artist = artist;
        this.harga = harga;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId_album() {
        return id_album;
    }

    public void setId_album(String id_album) {
        this.id_album = id_album;
    }

    public String getNamaAlbum() {
        return namaAlbum;
    }

    public void setNamaAlbum(String namaAlbum) {
        this.namaAlbum = namaAlbum;
    }

    public String getTgl_rilis() {
        return tgl_rilis;
    }

    public void setTgl_rilis(String tgl_rilis) {
        this.tgl_rilis = tgl_rilis;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}
