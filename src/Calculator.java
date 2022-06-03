import java.util.Scanner;

import util.Logger;

public class Calculator {
    private final Scanner scanner;

    public Calculator() {
        scanner = new Scanner(System.in);
    }

    public void startCalcultor() {
        Logger.info("계산기를 구동합니다.");
        while(true) {
            String command = scanner.next();
            if (isCommand()) {
                // 커멘드 입력이 온건지 확인!
            }
        }
    }

    private boolean isCommand(String command) {
        try {
            if ("History".equals(command))
                return true;
            if (Integer.parseInt(command) < 0)
                return false;
            return true;
        } catch (Exception e) {
            //TODO: handle exception
            return true;
        }
    }
}