package cn.rocky.utils;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 导出为Excel
 * 需要maven引入poi
 */
/*
<!-- https://mvnrepository.com/artifact/org.apache.poi/poi -->
        <dependency>
            <groupId>org.apache.poi</groupId>
            <artifactId>poi</artifactId>
            <version>3.16</version>
        </dependency>
 */

public class ExcelUtil {

    /***
     * 标题行开始位置
     */
    private static final int TITLE_START_POSITION = 0;

    /***
     * 时间行开始位置
     */
    private static final int DATEHEAD_START_POSITION = 1;

    /***
     * 表头行开始位置
     */
    private static final int HEAD_START_POSITION = 0;

    /***
     * 文本行开始位置
     */
    private static final int CONTENT_START_POSITION = 1;


    /**
     * @param dataList  对象集合
     * @param titleMap  表头信息（对象属性名称->要显示的标题值)[按顺序添加]
     * @param sheetName sheet名称和表头值
     */
    public static byte[] genExcel(List<Map<String, String>> dataList, List<String> titleMap,
                                  String sheetName) throws IOException {
        // 初始化workbook
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet(sheetName);
        // 表头行
        // 第1行创建
        HSSFRow headRow = sheet.createRow(HEAD_START_POSITION);
        for (int i = 0; i < titleMap.size(); i++) {
            HSSFCell headCell = headRow.createCell(i);
            headCell.setCellValue(titleMap.get(i));
        }

        // 文本行
        for (int i = 0; i < dataList.size(); i++) {
            HSSFRow textRow = sheet.createRow(CONTENT_START_POSITION + i);
            int j = 0;
            for (String field : titleMap) {
                String val = dataList.get(i).get(field);
                String value = (val == null ? "" : val);
                HSSFCell textcell = textRow.createCell(j);
                textcell.setCellValue(value);
                j++;
            }
        }
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream(workbook.getBytes().length);
        try {
            workbook.write(byteStream);
            return byteStream.toByteArray();
        } finally {
            if (byteStream != null) {
                byteStream.close();
                byteStream = null;
            }
        }


    }

}
