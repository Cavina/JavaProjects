package application;
import javafx.beans.property.*;
/*Creates a class of Person type.*/
//210 Bytes total

public class Person {
	private SimpleStringProperty firstName, lastName, gender,   
	streetAddress, email,  phoneNumber, zip, birthDate;
	

	/**Constructor for Person
	 * @param fn a 15 String representing first name.
	 * @param ln a 15 character String representing last name
	 * @param g a 2 character String representing Gender.
	 * @param addr a 25 character String representing the street address. 
	 * @param pNum  10 digit phone number as String
	 * @param z  5 character zip code as String
	 * @param bDate 8 character string as birth date in yyyymmdd
	 * @param em  25 character String as email
	 */
	public Person(String fn, String ln, String g, String addr, String pNum, String z, String bDate, String em) {
		if (fn.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for first name.");
		}
		if (ln.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for last name");
		}
		if(g.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for gender");
		}
		if(addr.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for address");
		}
		if(pNum.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for phone number");
		}
		if(z.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for zip code");
		}
		if(bDate.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for birthdate");
		}
		if(em.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String as email");
		}
		
		this.firstName = new SimpleStringProperty(fn);
		this.lastName = new SimpleStringProperty(ln);
		this.gender = new SimpleStringProperty(g);
		this.streetAddress = new SimpleStringProperty(addr);
		this.zip = new SimpleStringProperty(z);
		this.phoneNumber = new SimpleStringProperty(pNum);
		this.birthDate = new SimpleStringProperty(bDate);
		this.email = new SimpleStringProperty(em);
		

		
	}

	/**Constructor for Person
	 * @param fn a 15 String representing first name.
	 * @param ln a 15 character String representing last name
	 * @param g a 2 character String representing Gender.
	 * @param addr a 25 character String representing the street address. 
	 * @param pNum  10 digit phone number
	 * @param z  zip code
	 * @param bDate birth date in mmddyy
	 */
	public Person(String fn, String ln, String g, String addr, String pNum, String z, String bDate) {
		if (fn.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for first name.");
		}
		if (ln.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for last name");
		}
		if(g.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for gender");
		}
		if(addr.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for address");
		}
		if(pNum.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for phone number");
		}
		if(z.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for zip code");
		}
		if(bDate.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for birthdate");
		}
		
		this.firstName = new SimpleStringProperty(fn);
		this.lastName = new SimpleStringProperty(ln);
		this.gender = new SimpleStringProperty(g);
		this.streetAddress = new SimpleStringProperty(addr);
		this.zip = new SimpleStringProperty(z);
		this.phoneNumber = new SimpleStringProperty(pNum);
		this.birthDate = new SimpleStringProperty(bDate);
		
		
	}
	
	/*Changes the first name of the person*/
	/**
	 * @param fn first name of the person
	 */
	public void setFirstName(String fn)
	{
		if (fn.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for first name.");
		}
		firstName.set(fn);
	}
	/*Changes last name of the person*/
	/**
	 * 
	 * @param ln last name of the person
	 */
	public void setLastName (String ln)
	{
		if(ln.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for last name");
		}
		lastName.set(ln);;
	}
	
	public void setGender(String g)
	{
		if(g.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for gender");
		}
		gender.set(g);
	}
	
	public void setAddress(String addr)
	{
		if(addr.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a String for address");
		}
		streetAddress.set(addr);
	}
	
	public void setPhoneNumber(String pNum)
	{
		if(pNum.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for phone number");
		}
		phoneNumber.set(pNum);
	}
	
	public void setZipCode(String z)
	{
		if(z.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for zip code");
		}
		zip.set(z);
	}
	
	public void setBirthDate(String bDate)
	{
		if(bDate.isEmpty())
		{
			throw new IllegalArgumentException("Must enter an integer greater than zero for birthdate");
		}
		birthDate.set(bDate);
	}
	
	public void setEmail(String em)
	{
		if(em.isEmpty())
		{
			throw new IllegalArgumentException("Must enter a string for e-mail");
		}
		email.set(em);
	}
	
	public String getFirstName() {return firstName.get();}
	public String getLastName() {return lastName.get();}
	public String getAddress() {return streetAddress.get();}
	public String getGender() {return gender.get();}
	public String getZipCode() {return zip.get();}
	public String getPhoneNumber() {return phoneNumber.get();}
	public String getBirthDate() {return birthDate.get();}
	public String getEmail() {return email.get();}
	
	public String toString()
	{
		String message;
		message = String.format("First Name: %s\n"
				+ "Last Name: %s"
				+ "\nGender: %s"
				+ "\nAddress: %s"
				+ "\nE-mail: %s"
				+ "\nBirth date: %s/%s/%s"
				+ "\nPhone Number: %s"
				+ "\nZip Code: %s", firstName, lastName, gender, streetAddress, email, 
				birthDate.get().substring(4, 6), birthDate.get().substring(6, 8), birthDate.get().substring(0, 4), phoneNumber, zip);
		return message;
	}


}
