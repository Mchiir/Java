package StudentAppJson;

class Employee {
	 
    // Member variables of this class
    private String id;
    private String name;
    private String deptName;
    private double salary;
    private int rating;
 
    // Member methods of this class
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDeptName() { return deptName; }
    public void setDeptName(String deptName)
    {
        // This keyword refers to current instance
        this.deptName = deptName;
    }
 
    public double getSalary() { return salary; }
    public void setSalary(double salary)
    {
        this.salary = salary;
    }
    public int getRating() { return rating; }
    public void setRating(int rating)
    {
        this.rating = rating;
    }
 
    @Override public String toString()
    {
        return "Employee [id=" + id + ", name=" + name
            + ", deptName=" + deptName + ", salary="
            + salary + ", rating=" + rating + "]";
    }
}
