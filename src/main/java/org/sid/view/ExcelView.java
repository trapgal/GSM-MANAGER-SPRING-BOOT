package org.sid.view;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.sid.entities.PersonnelPuce;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.document.AbstractXlsView;


public class ExcelView extends AbstractXlsView{

	

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		List<PersonnelPuce> personnelPuces =  (List<PersonnelPuce>) model.get("liste");
		  Sheet sheet =  workbook.createSheet("Affectations");
		  Row header = sheet.createRow(0);
		  header.createCell(0).setCellValue(" Id");
		  header.createCell(1).setCellValue("Affect");
		  header.createCell(2).setCellValue("Desaffect");
		  int counter = 1;
		  for (PersonnelPuce p : personnelPuces) {
		   Row row = sheet.createRow(counter++);
		   row.createCell(0).setCellValue(p.getId());
		   row.createCell(1).setCellValue(p.getDateAffectation());
		   row.createCell(2).setCellValue(p.getDateDesaffectation());
		  }		
	}
	}