/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Processing;

import StockControl.Part;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import com.itextpdf.layout.property.UnitValue;
import java.util.ArrayList;

/**
 *
 * @author paul
 */
public class PDFCreator {
    public static final String NEWLINE = "\n";
    
    public static Table getAddressTable(String name, String address, String 
            postcode, PdfFont bold) {
        Table table = new Table(new UnitValue[]{
            new UnitValue(UnitValue.PERCENT, 50),
            new UnitValue(UnitValue.PERCENT, 50)})
                .setWidthPercent(100);
        table.addCell(getPartyAddress("Client:",
            name, address, postcode, bold));
        table.addCell(getPartyAddress("Seller:",
                "Quick Fix Fitters", "19 High St. Ashford,", "Kent CT16 8YY",
            bold));
        return table;
    }
    
    public static Cell getPartyAddress(String who, String name, String line1, String line2, PdfFont bold) {
    	Paragraph p = new Paragraph()
    			.setMultipliedLeading(1.0f)
        		.add(new Text(who).setFont(bold)).add(NEWLINE)
                .add(name).add(NEWLINE)
                .add(line1).add(NEWLINE)
                .add(line2).add(NEWLINE);
        Cell cell = new Cell()
        		.setBorder(Border.NO_BORDER)
        		.add(p);
        return cell;
    }
    
    public static Cell createCell(String text) {
        return new Cell().setPadding(0.8f)
            .add(new Paragraph(text)
                .setMultipliedLeading(1));
    }
    public static Cell createCell(String text, PdfFont font) {
        return new Cell().setPadding(0.8f)
            .add(new Paragraph(text)
                .setFont(font).setMultipliedLeading(1));
    }
    
    public static Table getLineItemTable(Invoice invoice, ArrayList<Part>
            partsUsed, Job selectedJob, PdfFont bold) {
        Table table = new Table(
            new UnitValue[]{
                new UnitValue(UnitValue.PERCENT, 34f),
                new UnitValue(UnitValue.PERCENT, 30f),
                new UnitValue(UnitValue.PERCENT, 12f),
                new UnitValue(UnitValue.PERCENT, 12f),
                new UnitValue(UnitValue.PERCENT, 12f)})
            .setWidthPercent(100)
        .setMarginTop(10).setMarginBottom(10);
            table.addHeaderCell(createCell("Item:", bold));
            table.addHeaderCell(createCell("Part No:", bold));
            table.addHeaderCell(createCell("Unit Cost:", bold));
            table.addHeaderCell(createCell("Qty:", bold));
            table.addHeaderCell(createCell("Cost:", bold));
            float totalDue = invoice.calcLabourCost(
                    invoice.getJobDuration(), invoice.getMechanicWage());
            float vatValue = 0;
            for(Part part : partsUsed) {
                table.addCell(createCell(part.getName()));
                table.addCell(createCell(part.getPartId()+""));
                table.addCell(createCell(part.getPrice()*1.3+""));
                table.addCell(createCell(part.getQty()+""));
                float markUpSpares = part.getPrice()*part.getQty();
                table.addCell(createCell(invoice.calcMarkUpSpares(markUpSpares)+""));
                if(part.getName().equals("Oil Filter") ||
                    part.getName().equals("Air Filter") ||
                    part.getName().equals("Motor Oil")) {
                } else {
                    totalDue += invoice.calcMarkUpSpares(markUpSpares);
                }
            }
            //WHITESPACE
            table.addCell(createCell("\n"));
            table.addCell(createCell("\n"));
            table.addCell(createCell("\n"));
            table.addCell(createCell("\n"));
            table.addCell(createCell("\n"));
            
            if(selectedJob.getFixedCost() > 0) {
                //Adding Fixed cost
                table.addCell(createCell(selectedJob.getType()+""));
                table.addCell(createCell(""));
                table.addCell(createCell(""));
                table.addCell(createCell(""));
                table.addCell(createCell(selectedJob.getFixedCost()+""));
                totalDue += selectedJob.getFixedCost();
            }

            table.addCell(createCell("Labour"));
            table.addCell(createCell(""));
            table.addCell(createCell(invoice.getMechanicWage()+""));
            table.addCell(createCell(invoice.getJobDuration()+""));
            table.addCell(createCell(invoice.calcLabourCost(
                    invoice.getJobDuration(), invoice.getMechanicWage())+""));
            
            table.addCell(createCell(""));
            table.addCell(createCell(""));
            table.addCell(createCell("Total"));
            table.addCell(createCell(""));
            table.addCell(createCell(totalDue+""));
            
            vatValue = (float) (0.2 * totalDue);
            table.addCell(createCell(""));
            table.addCell(createCell(""));
            table.addCell(createCell("VAT"));
            table.addCell(createCell(""));
            table.addCell(createCell(vatValue+""));

            table.addCell(createCell(""));
            table.addCell(createCell(""));
            table.addCell(createCell("Grand Total"));
            table.addCell(createCell(""));
            table.addCell(createCell(invoice.getAmountDue()+""));
        return table;
    }
    
}
