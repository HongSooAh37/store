package spms.bind;
//	클라이언트가 보낸 데이터가 필요한 경우 = DataBinding 구현
public interface DataBinding {
//	반환값 : 데이트의 이름, 타입 정보
  Object[] getDataBinders();
//  new Object[] {"데이터이름", "데이터타입", "데이터이름", "데이터타입",....}
}
