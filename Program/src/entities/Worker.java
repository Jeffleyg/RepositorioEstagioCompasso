package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department departement;
	private List<HourContract> contracts = new ArrayList<>();
	
	public Worker() {
		
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department departement) { 
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departement = departement;
	} // como nós temos uma lista não devemos inserir a lista no construtor, pois devemos iniciá-lo vazio.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartement() {
		return departement;
	}

	public void setDepartement(Department departement) {
		this.departement = departement;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}
	//removemos o setContract por nós implementamos um addContract e um removeContract.

	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public double income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance(); // calendar biblioteca de cendário para mexer com data.
		for(HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if(year == c_year && month == c_month) {
				
				sum += c.totalValue();
			}
		}
		return sum;
	}
	
}
