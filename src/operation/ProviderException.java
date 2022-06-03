package operation;

// 계산기에서 제공하지 않는 기능을 위한 별도의 Exception 클래스
public class ProviderException extends RuntimeException {
    // RuntimeException의 생성자를 호출하기 위한 생성자 셋팅
    public ProviderException(String msg) {
        super(msg);
    }
}
