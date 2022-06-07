import java.util.Scanner;

import history.History;
import history.impl.HistoryImpl;
import operation.Operation;
import operation.OperationFactory;
import util.Logger;

public class Calculator {
    // 기본 안내문구
    private final static String COMMAND_MSG = "커멘드를 입력하세요. (+, -, /, *, history, exit) : ";
    // final로 재할당이 불가능한 scanner
    private final Scanner scanner;
    // final로 재할당이 불가능한 히스토리 인터페이스
    private final History history;
    // 실시간으로 값을 저장하기 위한 멤버변수
    private double now = 0.0;

    public Calculator() {
        // 클래스 초기화시에 자동으로 scanner객체를 초기화 하도록 하는 로직
        scanner = new Scanner(System.in);
        // 계산 로그를 저장하기 위한 구현체 지정
        history = new HistoryImpl();
    }

    public void startCalcultor() {
        // 계산기의 연산을 도와줄 오퍼레이션 인터페이스를 바꿔가며 지정할 수 있는 변수 선언
        Operation operation = null;
        // 메세지를 받아서 뭘 행동해야 하는지 알려줄 수 있는 String 변수 선언
        String msg = "";
        Logger.info("계산기를 구동합니다.");
        while(true) {
            // 사용자 입력받기
            System.out.print(msg.isEmpty() ? COMMAND_MSG : msg + " : ");
            String command = scanner.next();
            // 커멘드 입력이 온건지 확인!
            if (isCommand(command)) {
                if ("history".equals(command)) {
                    // 지금까지 계산한 로그 출력
                    history.printHistory();
                } else if ("exit".equals(command)) {
                    // 종료 커맨드 탈출시 무한루프 탈출
                    Logger.info("계산기를 종료합니다.");
                    break;
                } else {
                    try {
                        // 계산기의 형식에 맞는 오퍼레이션을 대입
                        operation = OperationFactory.getOperation(command, history);
                        // 다음번 메세지를 지정해줌
                        msg = operation.getStatus();
                    } catch (Exception e) {
                        // 제대로된 커멘드가 아닐 경우 에러
                        System.out.println(e.getMessage());
                    }
                }
                // 이후 루프문은 진행하지 않음
                continue;
            }
            
            // 더블형태로 가져오기
            double input = Double.parseDouble(command);
            // 아직 연산자가 지정되어있지 않으면 안내하고 다시 처음부터
            if (operation == null) {
                System.out.println("아직 연산자가 지정되지 않았습니다. 다시 시도해주세요.");
                continue;
            }
            // 계산이 후 현재 값에 저장
            now = operation.doOperation(now, input);
            // 모두 초기값으로 되돌림
            operation = null;
            msg = "";
        }
    }

    private boolean isCommand(String command) {
        try {
            // Double.parseDouble를 통해서 숫자가 온건지 확인
            // 음수는 받지 않기 때문에 0 이상이면 숫자로 판단
            if (Double.parseDouble(command) >= 0)
                return false;
            return true;
        } catch (Exception e) {
            // parseInt에서 에러가 발생할 시 커멘드임
            return true;
        }
    }
}