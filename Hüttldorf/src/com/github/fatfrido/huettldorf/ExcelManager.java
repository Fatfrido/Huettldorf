package com.github.fatfrido.huettldorf;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.LabelCell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExcelManager {
	String filename = "Huettldorf";
	String year = "14";
	int yearnum = 14;
	
	public Workbook getWorkbook(String filename){
		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File(filename + ".xls"));
			return workbook;
		} catch (BiffException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Sheet getCatalogAndBalance(int year){
		Workbook workbook = this.getWorkbook(filename);
		Sheet sheet = workbook.getSheet(filename + year);
		return sheet;
	}
	
	public Sheet getConfiguration(int year){
		Workbook workbook = this.getWorkbook(filename);
		Sheet sheet = workbook.getSheet("Konfiguration" + year);
		return sheet;
	}
	
	public List<Double> getArticles(int year){
		Sheet sheet = getCatalogAndBalance(year);
		Cell starter = sheet.findCell("Art.Nr");
		int column = starter.getColumn();
		int row = starter.getRow() + 1;
		ArrayList<Double> articles = new ArrayList<Double>();
		int length = 0;
		for(int i = 0; i == length; i++){
			Cell cell = sheet.getCell(column, row + i);
			if(cell instanceof NumberCell){
				length++;
			}
		}
		for(int i = row; i <= length; i++){
			Cell cell = sheet.getCell(column, i);
			NumberCell nc = (NumberCell) cell;
			articles.add(nc.getValue());
		}
		return articles;
	}
	
	public ArrayList<String> getGroups(int year){
		Sheet sheet = getConfiguration(year);
		Cell starter = sheet.findCell("Gruppen");
		int column = starter.getColumn();
		int row = starter.getRow() + 1;
		ArrayList<String> groups = new ArrayList<String>();
		int length = 0;
		for(int i = 0; i == length; i++){
			Cell cell = sheet.getCell(column, row + i);
			if(cell instanceof LabelCell){
				length++;
			}
		}
		for(int i = row; i <= length; i++){
			Cell cell = sheet.getCell(column, i);
			LabelCell nc = (LabelCell) cell;
			groups.add(nc.toString());
		}
		return groups;
	}
}
