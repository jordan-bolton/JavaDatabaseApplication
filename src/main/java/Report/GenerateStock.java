package Report;

import Account.Vehicle;
import java.util.Date;
import StockControl.*;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class GenerateStock extends Reports {

    private List<Part> parts;

    /**
     *
     * @param report_name
     * @param date
     * @param stock
     */
    public GenerateStock(String report_name, Date date, List<Part> parts) {
        super(report_name, date);

        this.parts = parts;

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat reportDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fileNameString = "";
        String fileNameDate = "";
        String fileExt = ".pdf";
        int incrementer = 1;
        String reportDate = reportDateFormat.format(date);

        fileNameString = "SpareParts";
        fileNameDate = dateFormat.format(date);

        String filePath = "Reports/Spare Parts/"+ fileNameString + "-" + fileNameDate + fileExt;
        File file = new File(filePath);
        while (file.exists()) {
            file = new File(filePath.substring(0, filePath.lastIndexOf(".")) + " " + "(" + incrementer + ")" + fileExt);
            incrementer++;
        }

        Document document = new Document();

        try {
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(file));
            document.open();
            Font font1 = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);

            document.add(new Paragraph("Report\nSpare Parts" + " - " + reportDate, font1));

            document.add(new Paragraph("\nSpare Parts Count: " + parts.size()));

            PdfPTable table = new PdfPTable(7);
            table.setWidthPercentage(100);
            table.setSpacingBefore(30f);
            table.setSpacingAfter(20f);

            //float[] colWidths = {1f, 1f, 1f};
            //table.setWidths(colWidths);
            PdfPCell cell1 = new PdfPCell(new Paragraph("Name"));
            cell1.setPaddingTop(5.0f);
            cell1.setPaddingBottom(5.0f);
            PdfPCell cell2 = new PdfPCell(new Paragraph("Manufacturer"));
            cell2.setPaddingTop(5.0f);
            cell2.setPaddingBottom(5.0f);
            PdfPCell cell3 = new PdfPCell(new Paragraph("Vehicle Type"));
            cell3.setPaddingTop(5.0f);
            cell3.setPaddingBottom(5.0f);
            PdfPCell cell4 = new PdfPCell(new Paragraph("Year"));
            cell4.setPaddingTop(5.0f);
            cell4.setPaddingBottom(5.0f);
            PdfPCell cell5 = new PdfPCell(new Paragraph("Price"));
            cell5.setPaddingTop(5.0f);
            cell5.setPaddingBottom(5.0f);
            PdfPCell cell6 = new PdfPCell(new Paragraph("Quantity"));
            cell6.setPaddingTop(5.0f);
            cell6.setPaddingBottom(5.0f);
            PdfPCell cell7 = new PdfPCell(new Paragraph("Threshold"));
            cell7.setPaddingTop(5.0f);
            cell7.setPaddingBottom(5.0f);

            table.addCell(cell1);
            table.addCell(cell2);
            table.addCell(cell3);
            table.addCell(cell4);
            table.addCell(cell5);
            table.addCell(cell6);
            table.addCell(cell7);

            PdfPCell cellData1;
            PdfPCell cellData2;
            PdfPCell cellData3;
            PdfPCell cellData4;
            PdfPCell cellData5;
            PdfPCell cellData6;
            PdfPCell cellData7;

            for (Part p : parts) {
                cellData1 = new PdfPCell(new Paragraph(p.getName()));
                cellData2 = new PdfPCell(new Paragraph(p.getManufacturer()));
                cellData3 = new PdfPCell(new Paragraph(p.getVehicleType()));
                cellData4 = new PdfPCell(new Paragraph(String.valueOf(p.getYear())));
                cellData5 = new PdfPCell(new Paragraph(String.valueOf(p.getPrice())));
                cellData6 = new PdfPCell(new Paragraph(String.valueOf(p.getQty())));
                cellData7 = new PdfPCell(new Paragraph(String.valueOf(p.getThreshold())));

                cellData1.setPaddingTop(5.0f);
                cellData1.setPaddingBottom(5.0f);
                cellData2.setPaddingTop(5.0f);
                cellData2.setPaddingBottom(5.0f);
                cellData3.setPaddingTop(5.0f);
                cellData3.setPaddingBottom(5.0f);
                cellData4.setPaddingTop(5.0f);
                cellData4.setPaddingBottom(5.0f);
                cellData5.setPaddingTop(5.0f);
                cellData5.setPaddingBottom(5.0f);
                cellData6.setPaddingTop(5.0f);
                cellData6.setPaddingBottom(5.0f);
                cellData7.setPaddingTop(5.0f);
                cellData7.setPaddingBottom(5.0f);

                table.addCell(cellData1);
                table.addCell(cellData2);
                table.addCell(cellData3);
                table.addCell(cellData4);
                table.addCell(cellData5);
                table.addCell(cellData6);
                table.addCell(cellData7);
            }

            document.add(table);

            document.addCreationDate();
            document.addTitle("Spare Parts" + " - " + reportDate);
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void GenerateReport() {
        // TODO - implement GenerateStock.GenerateReport
        throw new UnsupportedOperationException();
    }

}
