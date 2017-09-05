package cn.rocky.utils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by rocky on 17/9/5.
 */
public class ExcelUtilTest {
    @Test
    public void genExcel() throws Exception {
        List<String> title = Lists.newArrayList("名字", "age");
        List<Map<String, String>> data = Lists.newArrayList();
        for (int i = 0; i < 15; i++) {
            Map<String, String> map = Maps.newHashMap();
            map.put("名字", "rocky" + i);
            map.put("age", "ddd" + i);
            data.add(map);
        }
        byte[] bytes = ExcelUtil.genExcel(data, title, "测试 sheet");
        FileUtil.file("/Users/rocky/test/test1.xls", bytes);
        System.out.println();
    }

    @Test
    public void test1() throws IOException {
        // 创建工作薄
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建工作表
        HSSFSheet sheet = workbook.createSheet("sheet1");

        for (int row = 0; row < 10; row++)
        {
            HSSFRow rows = sheet.createRow(row);
            for (int col = 0; col < 10; col++)
            {
                // 向工作表中添加数据
                rows.createCell(col).setCellValue("data" + row + col);
            }
        }

        File xlsFile = new File("/Users/rocky/test/poi.xls");
        FileOutputStream xlsStream = new FileOutputStream(xlsFile);
        workbook.write(xlsStream);
    }

}