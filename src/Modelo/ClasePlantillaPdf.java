
package Modelo;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import java.io.*;
import java.util.List;
import javax.swing.JOptionPane;

public class ClasePlantillaPdf {    //Inicio ClasePlantillaPDF
    
    //Atrbituos para la clase
    String NomDir;
    String Fch;
    List<ClaseGetPasajero> Lis;
    Document Doc;
    FileOutputStream Arc;
    Paragraph Tit;

    //Metodo Constructor
    public ClasePlantillaPdf(String NomDir, String Fch, List<ClaseGetPasajero> Lis) {
        this.NomDir = NomDir;
        this.Fch = Fch;
        this.Lis = Lis;

        Doc = new Document();
        Tit = new Paragraph("LISTADO DE PERSONAS SEGUN LA RUTA");
    }
    
    //Metodo para Crear la Plantilla del PDF
    public void CrearPlantilla() {  //Inicio Metodo CrearPlantilla
        try {   //Inicio Try
            Arc = new FileOutputStream(NomDir + ".pdf");    //Creamos un Objeto Archivo
            PdfWriter.getInstance(Doc, Arc);
            Doc.open(); //Inicio Documento
            Tit.setAlignment(1);    //Alineamos al centro el titulo
            Doc.add(Tit);   //Añadimos un titulo al documento
            
            //Añadimos un parrago con el 'Nombre'
            Doc.add(new Paragraph("Nombre: " + NomDir));
            Doc.add(Chunk.NEWLINE); //Salto de Linea

            //Creamos un objeto 'Tab' para la creacion de una tabla con 6 Columnas
            PdfPTable Tab = new PdfPTable(6);
            //Asignamos nombres a las 6 Columnas
            Tab.setWidthPercentage(100);
            PdfPCell NroVia = new PdfPCell(new Phrase("N° VIAJE"));
            NroVia.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell NomPas = new PdfPCell(new Phrase("PASAJERO"));
            NomPas.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell NroAsi = new PdfPCell(new Phrase("N° ASIENTO"));
            NroAsi.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell HorVia = new PdfPCell(new Phrase("HORA VIAJE"));
            HorVia.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell FecVia = new PdfPCell(new Phrase("FECHA VIAJE"));
            FecVia.setBackgroundColor(BaseColor.ORANGE);
            PdfPCell CosVia = new PdfPCell(new Phrase("COSTO"));
            CosVia.setBackgroundColor(BaseColor.ORANGE);

            //Añadimos las columnas a la tabla del documento
            Tab.addCell(NroVia);
            Tab.addCell(NomPas);
            Tab.addCell(NroAsi);
            Tab.addCell(HorVia);
            Tab.addCell(FecVia);
            Tab.addCell(CosVia);

            //Recorremos y llenamos la tabla del documento
            for (ClaseGetPasajero x : this.Lis) {   //Inicio For
                Tab.addCell(x.getViaNro());
                Tab.addCell(x.getNomPas());
                Tab.addCell(x.getNroAsi()+"");
                Tab.addCell(x.getHroVia());
                Tab.addCell(x.getFecVia()+"");
                Tab.addCell(x.getCosVia()+"");
            }   //Fin For
            Doc.add(Tab);   //Aladimos la tabla al documento
            Doc.add(Chunk.NEWLINE); //Salto de Linea
            Doc.add(new Paragraph("Fecha: " + Fch));    //Añadimos la fecha al documento

            Doc.close();    //Cierra el documento
            JOptionPane.showMessageDialog(null, "Archivo PDF Creado!");
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (DocumentException e) { //Inicio Catch
            System.err.println(e.getMessage());
        }   //Fin Catch
    }   //Fin Metodo CrearPlantilla
}   //Fin ClasePlantillaPDF