class Stock{
	String name;
	float change;
	Stock(String name1, float change1){
		this.name = name1;
		this.change = change1;
	}

	public String toString(Stock list1){
		return list1.name+" "+list1.change;
	}
}