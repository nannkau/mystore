package com.team.mystore.utils;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.team.mystore.entity.Invoice;
import com.team.mystore.entity.InvoiceDetail;
import com.team.mystore.entity.Recevie;
import com.team.mystore.entity.RecevieDetail;

import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

public class ExportBill {
    private static void writeTableHeader(PdfPTable table, Invoice invoice) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLUE);

        cell.setPhrase(new Phrase("Product", font));
        cell.setColspan(1);
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);
        for (InvoiceDetail invoiceDetail : invoice.getInvoiceDetails()) {
            table.addCell(invoiceDetail.getProduct().getName());
            table.addCell(String.valueOf(invoiceDetail.getAmount()));
            table.addCell(String.valueOf(invoiceDetail.getProduct().getPrice()));
        }
        cell.setColspan(2);
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);
        table.addCell(String.valueOf(invoice.getPriceTotal()));
        cell.setPhrase(new Phrase("Consumer", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(invoice.getConsumer().getName(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Address", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(invoice.getConsumer().getAddress(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Phone", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(invoice.getConsumer().getPhoneNumber(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("email", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(invoice.getConsumer().getEmail(), font));
        table.addCell(cell);

    }
    public static void export(HttpServletResponse response, Invoice invoice) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Bill", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f, 1.5f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeader(table,invoice);

        document.add(table);

        document.close();

    }
    public static void exportRecevie(HttpServletResponse response, Recevie recevie) throws DocumentException, IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font.setSize(18);
        font.setColor(Color.BLUE);

        Paragraph p = new Paragraph("Recevie", font);
        p.setAlignment(Paragraph.ALIGN_CENTER);

        document.add(p);

        PdfPTable table = new PdfPTable(3);
        table.setWidthPercentage(100f);
        table.setWidths(new float[] {3.5f, 1.5f, 3.0f});
        table.setSpacingBefore(10);

        writeTableHeaderRecevie(table,recevie);

        document.add(table);

        document.close();

    }

    private static void writeTableHeaderRecevie(PdfPTable table, Recevie recevie) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.WHITE);
        cell.setPadding(5);

        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.BLUE);

        cell.setPhrase(new Phrase("Product", font));
        cell.setColspan(1);
        table.addCell(cell);

        cell.setPhrase(new Phrase("Amount", font));
        table.addCell(cell);

        cell.setPhrase(new Phrase("Price", font));
        table.addCell(cell);
        for (RecevieDetail invoiceDetail : recevie.getRecevieDetails()) {
            table.addCell(invoiceDetail.getProduct().getName());
            table.addCell(String.valueOf(invoiceDetail.getAmountTotal()));
            table.addCell(String.valueOf(invoiceDetail.getProduct().getPrice()));
        }
        cell.setColspan(2);
        cell.setPhrase(new Phrase("Total", font));
        table.addCell(cell);
        table.addCell(String.valueOf(recevie.getPriceTotal()));
        cell.setPhrase(new Phrase("Supplier", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(recevie.getRecevieDetails().get(0).getProduct().getSupplier().getName(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Phone", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(recevie.getRecevieDetails().get(0).getProduct().getSupplier().getPhoneNumber(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Address", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(recevie.getRecevieDetails().get(0).getProduct().getSupplier().getAddress(), font));
        table.addCell(cell);
        cell.setPhrase(new Phrase("Employee", font));
        cell.setColspan(1);
        table.addCell(cell);
        cell.setColspan(2);
        cell.setPhrase(new Phrase(recevie.getEmployee().getName(), font));
        table.addCell(cell);
    }


}
