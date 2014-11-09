/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package datamining_proj;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class Users {

    public int userId;
    public String city;
    public String state;
    public String country;
    public String zipCode;
    public String degreeType;
    public String major;
    public String graduationDate;
    public int workHistoryCount;
    public int experience;
    public String isEmployed;
    public String isManager;
    public String managedCount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getDegreeType() {
		return degreeType;
	}
	public void setDegreeType(String degreeType) {
		this.degreeType = degreeType;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	public int getWorkHistoryCount() {
		return workHistoryCount;
	}
	public void setWorkHistoryCount(int workHistoryCount) {
		this.workHistoryCount = workHistoryCount;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getIsEmployed() {
		return isEmployed;
	}
	public void setIsEmployed(String isEmployed) {
		this.isEmployed = isEmployed;
	}
	public String getIsManager() {
		return isManager;
	}
	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}
	public String getManagedCount() {
		return managedCount;
	}
	public void setManagedCount(String managedCount) {
		this.managedCount = managedCount;
	}
}
