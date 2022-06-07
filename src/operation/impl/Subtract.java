package operation.impl;

import history.History;
import operation.Operation;
import util.Util;

public class Subtract implements Operation {
    private final static String STATUS_MESSAGE = "빼기를 수행할 숫자를 입력하세요.";
    private final History history;

    public Subtract(History history) {
        this.history = history;
    }

    @Override
    public double doOperation(double a, double b) {
        // TODO Auto-generated method stub
        double result = a - b;
        String log = a + " - " + b + " = " + Util.convertNumberToString(result);
        System.out.println(log);
        history.addHistory(log);
        return result;
    }

    @Override
    public String getStatus() {
        // TODO Auto-generated method stub
        return STATUS_MESSAGE;
    }

}
