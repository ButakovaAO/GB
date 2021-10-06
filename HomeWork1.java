class HomeWork1 {
    public static void main(String[] args) {
	printThreeWords();
	System.out.println("");
	checkSumSign();
	System.out.println("");
	printColor();
	System.out.println("");
	compareNumbers();
    }  
        public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
        }
        public static void checkSumSign() {
        int a = 3;
        int b = 6;
        a += b;
            if (a >= 0) {
                System.out.println("Сумма положительная");
            }
            else {
                System.out.println("Сумма отрицательная");
            }
        }
		public static void printColor() {
        int value = 3;
            if (value <= 0) {
                System.out.println("Красный");
            }
            if (value > 0 && value <= 100) {
                System.out.println("Желтый");
            }
			if (value > 100) {
                System.out.println("Зеленый");
            }
        }
		public static void compareNumbers() {
        int a = 1;
        int b = 10;
        System.out.println(a >= b? "a >= b" : "a < b");
        }
}

