enum RomanDigit {
    C(100), XC(90), L(50),XL(40), X(10),
    IX(9), VIII(8), VII(7), VI(6), V(5),
    IV(4), III(3),II(2), I(1);
    private int value;
    private RomanDigit(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
