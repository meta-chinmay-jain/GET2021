package com.ques1;

import java.util.Objects;

/**
 * Class to implement Java collections for operations based on various
 * attributes.
 * 
 * @author Chinmay Jain
 * @version 1.0
 * @since 2021-03-14
 */
public class Employee implements Comparable<Employee> {
	private final String empId;
	private final String name;
	private String address;

	public Employee(String empId, String name, String address) {
		this.empId = empId;
		this.name = name;
		this.address = address;
	}

	@Override
	public int hashCode() {
		return Objects.hash(empId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) obj;
		return Objects.equals(empId, other.empId);
	}

	@Override
	public String toString() {
		return "\nEmployee ID: " + empId + "\nName: " + name + "\nAddress: " + address + "\n";
	}

	@Override
	public int compareTo(Employee employee) {
		return this.empId.compareToIgnoreCase(employee.getEmpId());
	}

	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
