package com.my.pdftest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.AcroFields;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfCell;
import com.lowagie.text.pdf.PdfReader;
import com.lowagie.text.pdf.PdfStamper;
import com.lowagie.text.pdf.PdfWriter;

public class ExportPDF {
       public void exportInsurancePDF() throws DocumentException{
           
           List<String> ponum=new ArrayList<String>();
           for(int i=0;i<311;i++){
               ponum.add("test"+i);
            }
           List<String> line=new ArrayList<String>();
           for(int i=0;i<311;i++){
               line.add("test"+i);
            }
           List<String> part=new ArrayList<String>();
           for(int i=0;i<311;i++){
               part.add("test"+i);
            }
           List<String> description=new ArrayList<String>();
           for(int i=0;i<311;i++){
               description.add("test"+i);
            }
           List<String> origin=new ArrayList<String>();
           for(int i=0;i<311;i++){
               origin.add("test"+i);
            }
           
           
           
           File  file = new File("E:/pdf/test6.pdf");
           FileOutputStream outputStream = null;
           try {
            outputStream = new FileOutputStream(file);
            
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           //创建一个document页面对象
           Document document = new Document(PageSize.A4, 50, 50, 50, 50);
           
           //增加中文字体
           BaseFont bfChinese = null;
           try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        } catch (DocumentException | IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
           Font keyFont = new Font(bfChinese, 8, Font.BOLD);
           Font textFont = new Font(bfChinese, 12, Font.BOLD);
           
           //创建一个书写器与页面document相关联
           PdfWriter writer = null;
           try {
            writer = PdfWriter.getInstance(document, outputStream);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           String arr[] = {"PO#","LINE#","PART#","des#","ORG#"};
           
           //必须放在open前，否则第一页不会显示页码
           HeaderFooter footer = new HeaderFooter(new Phrase("页码：",keyFont), true);
           footer.setBorder(Rectangle.NO_BORDER);
           footer.setAlignment(PdfCell.ALIGN_CENTER);
           document.setFooter(footer);
           
           document.open();
           
           document.addTitle("试验用PDF");
           document.addSubject("投保明细清单");
           document.addAuthor("苟利国家生死以，岂因祸福避趋之");
           document.addCreationDate();
           
           int recordPage = 30;//加入页码
           int fullPage = ponum.size()/recordPage;
           int remainPage = ponum.size()%recordPage>1?1:0;
           int totalPage = fullPage+remainPage;
           
           
           
           for (int i = 0; i < totalPage; i++) {
           document.newPage();
           String pageNo = "页码: "+(i+1)+" / "+totalPage;
           Paragraph pageNum = new Paragraph(pageNo, keyFont);
           pageNum.setAlignment(PdfCell.ALIGN_CENTER);
           try {
            document.add(pageNum);
            } catch (DocumentException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
           Image image = null;//创建图片显示
           try {
            image = Image.getInstance("E:/pdf/img.jpg");
        } catch (BadElementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           image.setAlignment(Image.ALIGN_RIGHT);
           image.scaleAbsolute(100, 100);
           image.setAbsolutePosition(400, 50);
           try {
            document.add(image);
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
           
           Table table = null;//创建table表格
           try {
            table = new Table(5);
        } catch (BadElementException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           float[] widths={1.5f,1f,1f,1.5f,1f};
           table.setWidths(widths);
           //table.setWidth(100);
           table.getDefaultCell().setBorder(1);
           table.getDefaultCell().setBorderWidthRight(1);
           //table.getDefaultCell().setUseAscender(true);
           table.setPadding(3);
           table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
           //table.getDefaultCell().setVerticalAlignment(Element.ALIGN_TOP);
           
           for (int k = 0; k < arr.length; k++) {
               Cell cell1 = new Cell(new Paragraph(arr[k], textFont));
               cell1.setUseAscender(true);
               cell1.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell1);
           }
           
          
           
           int maxRecordInPage= i+1 ==totalPage ? (remainPage==0?recordPage:(ponum.size()%recordPage)):recordPage;
           
           for(int j=i*recordPage;j<((i*recordPage)+maxRecordInPage);j++){
               Cell cell = new Cell(new Paragraph(ponum.get(j), textFont));
               cell.setUseAscender(true);
               cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell);
               cell = new Cell(new Paragraph(line.get(j), textFont));
               cell.setUseAscender(true);
               cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell);
               cell = new Cell(new Paragraph(part.get(j), textFont));
               cell.setUseAscender(true);
               cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell);
               cell = new Cell(new Paragraph(description.get(j), textFont));
               cell.setUseAscender(true);
               cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell);
               cell = new Cell(new Paragraph(origin.get(j), textFont));
               cell.setUseAscender(true);
               cell.setVerticalAlignment(Cell.ALIGN_MIDDLE);
               table.addCell(cell);
           }
           document.add(table);
           }
           
           document.close();
       }
       
       public void updatePDF() throws IOException, DocumentException{
           File  file = new File("E:/pdf/test3.pdf");
           FileOutputStream outputStream = null;
           try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
           
          
           PdfReader reader = new PdfReader("E:/pdf/test2.pdf");
        
           PdfStamper stamper = new PdfStamper(reader, outputStream);
           
           AcroFields filed = stamper.getAcroFields();
           filed.setField("peopleNum", "99999999");
           filed.setField("totalAmtCh", "壹亿捌仟万捌仟八佰捌拾捌");
           filed.setField("totalAmt", "19999999999");
           
           stamper.setFormFlattening(true);
           stamper.close();
           
           
       }
       
       public static void main(String[] args) {
        ExportPDF exportPDF = new ExportPDF();
        try {
            exportPDF.exportInsurancePDF();
            //exportPDF.updatePDF();
        } catch (DocumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } /*catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }*/
    }
}
