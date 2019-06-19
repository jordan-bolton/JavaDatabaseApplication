package Report;

import java.util.Date;
import Account.*;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
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

public class NumOfVehicles extends Reports {

    private String filter;
    private String name;
    private List<Vehicle> vehicles;
    private Customer[] customers;
    private String job_type;
    private Date period;

    /**
     *
     * @param report_name
     * @param date
     * @param filter
     * @param name
     * @param vehicles
     * @param period
     */
    public NumOfVehicles(String report_name, Date date, String name, List<Vehicle> vehicles, Date period) {
        super(report_name, date);

        this.vehicles = vehicles;
    }

    /**
     *
     * @param report_name
     * @param date
     * @param filter
     * @param name
     * @param vehicles
     * @param job_type
     */
    public NumOfVehicles(String report_name, Date date, String name, List<Vehicle> vehicles, String job_type) {
        super(report_name, date);
    }

    public NumOfVehicles(String report_name, Date date, String filter, List<Vehicle> vehicles) {
        super(report_name, date);
        this.vehicles = vehicles;

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        DateFormat reportDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fileNameString = "";
        String fileNameDate = "";
        String fileExt = ".pdf";
        int incrementer = 1;
        String reportDate = reportDateFormat.format(date);

        if (filter == "Overall") {
            fileNameString = "NumOfVehicles-overall";
            fileNameDate = dateFormat.format(date);

            String filePath = "Reports/No. of Vehicles/Overall/" + fileNameString + "-" + fileNameDate + fileExt;
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
                
                document.add(new Paragraph("Report\nNumber Of Vehicles " + "(" + filter + ")" + " - " + reportDate, font1));

                document.add(new Paragraph("\nNumber of Vehicles Count: " + vehicles.size()));
                
                PdfPTable table = new PdfPTable(7);
                table.setWidthPercentage(100);
                table.setSpacingBefore(30f);
                table.setSpacingAfter(20f);

                //float[] colWidths = {1f, 1f, 1f};
                //table.setWidths(colWidths);
                PdfPCell cell1 = new PdfPCell(new Paragraph("Registration No."));
                cell1.setPaddingTop(5.0f);
                cell1.setPaddingBottom(5.0f);
                PdfPCell cell2 = new PdfPCell(new Paragraph("Make"));
                cell2.setPaddingTop(5.0f);
                cell2.setPaddingBottom(5.0f);
                PdfPCell cell3 = new PdfPCell(new Paragraph("Model"));
                cell3.setPaddingTop(5.0f);
                cell3.setPaddingBottom(5.0f);
                PdfPCell cell4 = new PdfPCell(new Paragraph("Colour"));
                cell4.setPaddingTop(5.0f);
                cell4.setPaddingBottom(5.0f);
                PdfPCell cell5 = new PdfPCell(new Paragraph("Engine Serial No."));
                cell5.setPaddingTop(5.0f);
                cell5.setPaddingBottom(5.0f);
                PdfPCell cell6 = new PdfPCell(new Paragraph("Chassis No."));
                cell6.setPaddingTop(5.0f);
                cell6.setPaddingBottom(5.0f);
                PdfPCell cell7 = new PdfPCell(new Paragraph("Purchase Date"));
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

                for (Vehicle v : vehicles) {
                    cellData1 = new PdfPCell(new Paragraph(v.getReg_num()));
                    cellData2 = new PdfPCell(new Paragraph(v.getMake()));
                    cellData3 = new PdfPCell(new Paragraph(v.getModel()));
                    cellData4 = new PdfPCell(new Paragraph(v.getColour()));
                    cellData5 = new PdfPCell(new Paragraph(v.getEngine_serial_no()));
                    cellData6 = new PdfPCell(new Paragraph(v.getChassis_no()));
                    cellData7 = new PdfPCell(new Paragraph(v.getPurchase_date()));

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
                document.addTitle("Number Of Vehicles" + " - " + reportDate);
                document.close();
                writer.close();
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }
        if (filter == "") {

        }
    }

    /**
     *
     * @param report_name
     * @param date
     * @param filter
     * @param name
     * @param vehicles
     * @param cust
     */
    public void GenerateReport() {
        // TODO - implement NumOfVehicles.GenerateReport
        throw new UnsupportedOperationException();
    }

}
