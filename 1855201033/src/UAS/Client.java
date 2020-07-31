/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UAS;

/**
 *
 * @author Bukhari_Inst
 */
public class Client {

    private int id;
    private String nama;
    private String jeniskelamin;
    private String nokamar;
    private String nohp;
    private String addDate;
    private byte[] picture;

    public Client(int pid, String pname, String jk, String kmr, String hp, String pAddDate, byte[] pimg) {
        this.id = pid;
        this.nama = pname;
        this.jeniskelamin = jk;
        this.nokamar = kmr;
        this.nohp = hp;
        this.addDate = pAddDate;
        this.picture = pimg;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return nama;
    }

    public String getJk() {
        return jeniskelamin;
    }

    public String getNokamar() {
        return nokamar;
    }

    public String getNohp() {
        return nohp;
    }

    public String getAddDate() {
        return addDate;
    }

    public byte[] getImage() {
        return picture;
    }
}
