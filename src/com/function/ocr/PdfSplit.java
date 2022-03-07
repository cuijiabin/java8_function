package com.function.ocr;


import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * @Author: cuijiabin
 * @Date: 2022-02-07 16:00
 */
public class PdfSplit {

    public static void main(String[] args) {
        String inputFile = "E:\\file\\book\\convert\\变分法基础\\第2章-固定边界的变分问题-71页.pdf";
        splitFile(inputFile, 1, 3);
    }

    public static String splitFile(String pdfFile, Integer from, Integer end) {

        Document document = null;
        PdfCopy copy = null;
        try {
            PdfReader reader = new PdfReader(pdfFile);
            int n = reader.getNumberOfPages();
            if (end == 0) {
                end = n;
            }
            List<String> savepaths = new ArrayList<String>();
            int a = pdfFile.lastIndexOf(".pdf");
            String staticpath = pdfFile.substring(0, a);
            String savepath = staticpath + "_from_" + from + "_to_" + end + "_.pdf";
            savepaths.add(savepath);
            document = new Document(reader.getPageSize(1));
            copy = new PdfCopy(document, new FileOutputStream(savepaths.get(0)));
            document.open();
            for (int j = from; j <= end; j++) {
                document.newPage();
                PdfImportedPage page = copy.getImportedPage(reader, j);
                copy.addPage(page);
            }
            document.close();
            return new File(savepath).getName();
        } catch (IOException e) {
            return null;
        } catch (DocumentException e) {
            return null;
        }
    }
}
