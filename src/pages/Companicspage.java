package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameWork.Data;

public class Companicspage {
	@FindBy(xpath ="//a[@style='background: rgb(152, 89, 182);']") WebElement companies;
    @FindBy(xpath = "//a[@title='New Contact']") WebElement newcompanices;
    @FindBy(xpath = "//input[@id=\"company_name\"]") WebElement company;
    @FindBy(xpath = "//input[@name='industry']") WebElement industry;
    @FindBy(xpath = "//input[@id='annual_revenue']") WebElement AnnualRevenue;
    @FindBy(xpath = "//input[@name='num_of_employees']") WebElement Employees;
    @FindBy(xpath = "//option[@value='Active']") WebElement Status;
    @FindBy(xpath = "//option[@value='Client']") WebElement Category;
    @FindBy(xpath = "//option[@value='High']") WebElement Priority;
    @FindBy(xpath = "//option[@value='Email']") WebElement Source;
    @FindBy(xpath = "//input[@name='identifier']") WebElement Identifier;
    @FindBy(xpath = "//input[@id='vat_number']") WebElement VATTaxNumber;
    @FindBy(xpath = "//input[@id='phone']") WebElement Phone;
    @FindBy(xpath = "//input[@id='fax']") WebElement Fax;
    @FindBy(xpath = "//input[@id='website']") WebElement Website;
    @FindBy(xpath = "//input[@id='email']") WebElement Email;
    @FindBy(xpath = "//input[@id='symbol']") WebElement Symbol;
    @FindBy(xpath = "//input[@name='client_lookup']") WebElement ParentCompany;
    @FindBy(xpath = "//select[@name='owner_user_id']") WebElement Owner	;
    @FindBy(xpath = "//input[@name='address_title']") WebElement AddressTitle;
    @FindBy(xpath = "//select[@name='type']") WebElement Type;
    @FindBy(xpath = "//textarea[@name=\"address\"]") WebElement DefaultAddress;
    @FindBy(xpath = "//input[@name='city']") WebElement City;
    @FindBy(xpath = "//input[@name='state']") WebElement StateProvince;
    @FindBy(xpath = "//input[@name='postcode']") WebElement ZipPostalCode;	
    @FindBy(xpath = "//input[@name='country']") WebElement Country;
    @FindBy(xpath = "//input[@name='tags']") WebElement Tags;
    @FindBy(xpath = "//textarea[@class='mceEditor']")WebElement Description;

 public void Companicspage() {
 	PageFactory.initElements(Data.driver, this);
 }
 public void enter_company_detais() {
	 companies.click();
	 newcompanices.click();
	 company.sendKeys("InfoTech");
	 industry.sendKeys("RuppaIndustry");
	 AnnualRevenue.sendKeys("1,67,890");
	 Employees.sendKeys("17000");
	 Status.sendKeys("Hello world");
	 Category.sendKeys("Selenium");
	 Priority.sendKeys("Java");
	 Source.sendKeys("Company");
	 Identifier.sendKeys("Source");
	 VATTaxNumber.sendKeys("12345689");
	 Phone.sendKeys("8142606311");
	 Fax.sendKeys("1432");
	 Website.sendKeys("www.InfoTech.com");
	 Email.sendKeys("sandyreddy126@gmail.com");
	 Symbol.sendKeys("@457");
	 ParentCompany.sendKeys("InfoTech");
	 Owner.sendKeys("Sudhanandha");
 }
 public void enter_address_details() {
	 AddressTitle.sendKeys("Btm Layout");
	 Type.sendKeys("kjhgflk");
	 DefaultAddress.sendKeys("Marthahalli");
	 City.sendKeys("Bangalor");
	 StateProvince.sendKeys("Karnataka");
	 ZipPostalCode.sendKeys("56002");
	 Country.sendKeys("America");
	 
 }
 }