## 설계 원칙 : SOLID
객체 지향적으로 설계하는데 기본이 되는 설계원칙 : SOLID  
+ 단일 책임 원칙 (Single responsibility principle : SRP)
+ 개방 - 폐쇄 원칙 (Open - closed principle : OCP)
+ 리스코프 치환 원칙 (Liskov substitution principle : LSP)
+ 인터페이스 분리 원칙 (Interface segregation principle : ISP)
+ 의존 역전 원칙 (Dependency invenstion principle : DIP)
##

### 1. 단일 책임 원칙 (SRP)
객체 지향의 기본은 책임을 객체에게 할당하는 데 있다. 객체를 객체로 존재하게 하는 이유가 책임인데, 단일 책임 원칙(SRP)는 이 책임과 관련된 원칙이다.  
 + 클래스는 단 한 개의 책임을 가져야 한다.  

클래스가 여러 책임을 갖게 되면 그 클래스는 각 책임마다 변경되는 이유가 발생하기 때문에, 클래스가 한 개의 이유로만 변경되려면 클래스는 한 개의 책임만을 가져야 한다.  
이런 이유로 이 원칙은 다른 말로 "클래스를 변경하는 이유는 단 한개여야 한다."고도 표현한다.  

**단일 책임 원칙이 잘 지켜지지 않으면 다른 원칙들도 그 효과가 반감되기 때문에 최대한 지켜야하는 원칙이 바로 '단일 책임 원칙'이다.**

#### 1.1 단일 책임 원칙 위반이 불러오는 문제점
책임의 개수가 많아질 수록 한 책임의 기능 변화가  다른 책임에 주는 영향은 비례해서 증가하게 되는데, 이는 결국 코드를 절차 지향적으로 만들어 변경을 어렵게 만든다.

한 클래스에 섞여 있던 책임을 두 클래스로 분리함으로써 변경의 여파를 줄일 수 있게 되는 것이다.

단일 책임 원칙을 어길 떄 발생하는 또 다른 문제점은 재사용을 어렵게 한다는 것이다.

#### 1.2 책임이란 변화에 대한 것
기능 변경 요구가 없을 때 수정에 대한 문제가 없다는 것은, 뒤집어 보면 책임의 단위는 변화되는 부분과 관련된다는 의미가 된다.

서로 다른 이유로 바뀌는 책임들이 한 클래스에 함께 포함되어 있다면, 이 클래스는 단일 책임 원칙을 어기고 있다고 볼 수 있다.

어떻게 하면 단일 책임 원칙을 지킬 수 있을까? - 그 방법은 바로 **메서드를 실행하는 것이 누구인지 확인해 보는 것이다.**

클래스의 사용자들이 서로 다른 메서드들을 사용한다면 그들 메서드는 각각 다른 책임에 속할 가능성이 높고, 따라서 책임 분리 후보가 될 수 있다.
##
### 2. 개방 폐쇄 원칙 (OCP)
+ 확장에는 열려 있어야 하고, 변경에는 닫혀 있어야 한다. **즉 , 기능을 변경하거나 확장할 수 있으면서, 그 기능을 사용하는 코드는 수정하지 않는다.**
~~~
FlowController를 사용할 때, ByteSource를 읽어오는 형태는 확장할 수 있다(파일, 소켓, 메모리 등) 그러나  확장을 하였다고 새로운 기능을 사용할 FlowControoler 클래스의 코드는 변경되지 않는다.  
즉 , 기능을 확장하면서도 기능을 사용하는 기존 코드는 변경되지 않는 것이다. 이를 개방 폐쇄 원칙은 (사용되는 기능의) 확장에는 열려있고 (기능을 사용하는 코드의) 변경에는 닫혀있다고 표현한 것이다. p111
~~~
개방 폐쇄 원칙을 구현할 수 있는 이유는 확장되는 부분(즉, 변화되는 부분)을 추상화해서 표현했기 때문이다.

개방 폐쇄 원칙을 구현하는 또 다른 방법은 **상속**을 이용하는 것이다.  
상속은 상위 클래스의 기능을 그대로 사용하면서 하위 클래스에서 일부 구현을 오버라이딩할 수 있는 방법을 제공한다.

#### 2.1 개방 폐쇄 원칙이 꺠질 떄의 주요 증상
추상화와 다형성을 이용해서 개방 폐쇄 원칙을 구현하기 때문에, 추상화와 다형성이 제대로 지켜지지 않은 코드는 개방 폐쇄 원칙을 어기게 된다.  
개방 폐쇄 원칙을 어기는 코드의 전형적인 특징은 다음과 같다.
+ 다운 캐스팅을 한다.  
    + instanceof와 같은 타입 확인 연산자가 사용된다면 해당 코드는 개방 폐쇄 원칙을 지키지 않을 가능성이 높다.   
    이런 경우에는 타입 캐스팅 후 실행하는 메서드가 변화 대상인지 확인 해봐야 한다.
+ 비슷한 if-else 블록이 존재한다.

#### 2.2 개방 폐쇄 원칙은 유연함에 대한 것
걔방 폐쇄 원칙은 변경의 유연함과 관련된 원칙이다. 개방 폐쇄 원칙은 변화되는 부분을 추상화함으로써 사용자 입장에서 변화를 고정시킨다.  

개방 폐쇄 원칙은 변화가 예상되는 것을 추상화해서 변경의 유연함을 얻도록 해준다. 이 말은 변화되는 부분을 추상화하지 못하면(또는 안 하면) 개방 폐쇄 원칙을 지킬 수 없게 되어 시간이 흐를수록 기능 변경이나 확장을 어렵게 만든다는 것을 뜻한다.  
**따라서 코드에 대한 변화 요구가 발생하면, 변화와 관련된 구현을 추상화해서 개방 폐쇄 원칙에 맞게 수정할 수 있는지 확인하는 습관을 갖도록하자.**
##
### 3. 리스코트 치환 원칙(Liskov substitution principle)
개방 폐쇄 원칙은 추상화와 다형성(상속)을 이용해서 구현했는데, 리스코트 치환 원칙은 개방 폐쇄 원칙을 받쳐주는 다형성에 관한 원칙을 제공한다.  
+ 상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야 한다.  
리스코트 치환 원칙이 제대로 지켜지지 않으면 다형성에 기반한 개방 폐쇄 원칙 역시 지켜지지 않기 떄문에, 리스코프 치환 원칙을 지키는 것은 매우 중요하다.  

#### 3.1 리스코프 치환 원칙을 지키지 않을 떄의 문제
리스코프 치환 원칙을 어기는 흔한 예는, 상위 타입에서 지정한 리턴 값의 범위에 해당되지 않는 값을 리턴하는 것이다.  
#### 3.2 리스코프 치환 원칙은 계약과 확장에 대한 것
리스코프 치환 원칙은 기능의 명세(또는 계약)에 대한 내용이다. 
기능 실행의 계약과 관련해서 흔히 발생하는 위반 사례  
+ 명시된 명세에서 벗어난 값을 리턴한다.  
+ 명시된 명세에서 벗어난 익셉션을 발생한다.  
+ 명시된 명세에서 벗어난 기능을 수행한다.  

하위 타입이 이렇게 명세에서 벗어난 동작을 하게 되면, 이 명세에 기반해서 구현한 코드는 비정상적으로 동작할 수 있기 때문에,  
하위 타입은 상위 타입에서 정의한 명세를 벗어나지 않는 범위에서 구현해야 한다.


또한, 리스코프 치환 원칙은 확장에 대한 것이다. 리스코프 치환 원칙을 어기면 개방 폐쇄 원칙을 어길 가능성이 높아진다.  
즉, 리스코프 치환 원칙을 지키지 않게 되면, 향후에 기능을 변경하거나 확장할 때 더 많은 코드를 수정할 가능성이 높아지게 된다(폐쇄 원칙이 이루어지지 않음)  
##
### 4. 인터페이스 분리 원칙(Interface segregation principle : ISP)  
+ 인터페이스는 그 인터페이스를 사용하는 클라이언트를 기준으로 분리해야 한다.
~~~
이 원칙의 정의는 "클라이언트는 자신이 사용하는 메서드에만 의존해야 한다."로 되어 있다"
~~~
인터페이스 분리 원칙은 C나 C++과 같이 컴파일 후 링크 과정이 필요한 언어에만 관련된 것은 아니다. 용도에 맞게 인터페이스를 분리하는 것은 단일 책임 원칙과도 연결된다.  
단일 책임 원칙에서 봤듯이 하나의 타입에 여러 기능이 섞여 있을 경우 한 기능의 변화로 인해 다른 기능이 영향을 받을 가능성이 높아진다.  
또한, 단일 책임 원칙이 잘 지켜질 때 이너페이스와 콘크리트 클래스의 재사용 가능성을 높일 수 있으므로 인터페이스 분리원칙은 겱국 인터페이스와 콘크트리 클래스의 재사용성을 높여주는 효과도 갖는다.  


#### 4.1 인터페이스 분리 원칙은 클라이언트에 대한 것
인터페이스 분리 원칙은 클라이언트 입장에서 인터페이스를 분리하라는 원칙이다.  
각 클라이언트가 사용하는 기능을 중심으로 인터페이스를 분리함으로써, 클라이언트로부터 발생하는 인터페이스 변경의 여파가 다른 클라이언트에 미치는 영향을 최소화할 수 있게 된다.  
##
### 5. 의존 역전 원칙 (Dependency inversion principle : DIP)
+ 고수준 모듈은 저수준 모듈의 구현에 의존해서는 안 된다. 저수준 모듈이 고수준 모듈에서 정의한 추상 타입에 의존해야 한다.
~~~
고수준 모듈 : 어떤 의미 있는 단일 기능을 제공하는 모듈  
    예: 바이트 데이터를 읽어와 암호화하고 결과 바이트 데이터를 쓴다.    
저수준 모듈 : 고수준 모듈의 기능을 구현하기 위해 필요한 하위 기능의 실제 구현  
    예 : 1. 파일에서 바이트 데이터를 읽어온다.  
        2. AES 알고리즘으로 암호화한다.
        3. 파일에 바이트 데이터를 쓴다.
        
        
~~~
#### 5.1 고수준 모듈이 저수준 모듈에 의존할 떄의 문제  
고수준 모듈은 상대적으로 큰 틀(즉, 상위 수준)에서 프로그램을 다룬다면, 저수준 모듈은 각 개별 요소(즉, 상세)가 어떻게 구현될지에 대해서 다룬다.  
프로젝트 초기에 요구 사항이 어느 정도 안정화되면 이후부터는 큰 틀에서 프로그램이 변경되기보다는 상세 수준에서의 변경이 발생할 가능성이 높아진다.  
#### 5.2 의존 역전 원칙을 통한 변경의 유연함 확보  
의존 역전 원칙은 이런 문제(저수준 모듈의 변경이 고수준 모듈의 변경을 초래하는 상황)를 저수준 모듈이 고수준 모듈을 의존하게 만들어서 해결한다.  
고수준 모듈에서 저수준 모듈을 사용한다는 것은 고수준 모듈이 저수준 모듈에 의존한다는 의미인데, 어떻게 저소준 모듈이 고수준 모듈을 의존하게 만든다는 걸까?  **답은 추상화에 있다.**
의존 역전 원칙은 앞서 리스코프 치환 원칙과 함꼐 개방 폐쇄 원칙을 따르는 설계를 만들어 주는 기반이 된다. 
#### 5.3 소스 코드 의존과 런타임 의존  
의존 역전 원칙은 소스 코드에서의 의존을 역전시키는 원칙이다. 의존 역전 원칙은 런타임의 의존이 아닌, 소스 코드의 의존을 역전시킴으로써 변경의 유연함을 확보할 수 있도록 만들어 주는 원칙이지, 런타임에서의 의존을 역전시키는 것은 아니다.  
#### 5.4 의존 역전 원칙과 패키지  
의존 역전 원칙은 타입의 소유도 역전시킨다. 타입의 소유 역전은 각 패키지를 독립적으로 배포할 수 있도록 만들어 준다,(독립적으로 배포한다는 건 jar파일이나 DDL 등의 파일로 배포한다는 것을 뜻한다.)  
따라서 의존 역전 원칙은 개방 폐쇄 원칙을 클래스 수준뿐만 아니라 패키지 수준까지 확싱시켜주는 디딤돌이 된다.  
##
### 6. SOLID 정리  
SOLID 원칙을 한마디로 정의하면 **변화에 유연하게 대처할 수 있는 설계 원칙이다.**  
객체가 커지지 않도록 예방 : 단일 책임 원칙, 인터페이스 분리 원칙  
개방 폐쇄 원칙을 지원 : 리스코프 치환 원칙, 의존 역전 원칙  
  + 변화 되는 부분 추상화 : 의존 역전 원칙  
  + 다형성을 도와주는 원칙 : 리스코프 치환 원칙  
또한  SOLID 원칙은 사용자 입장에서의 기능 사용을 중시한다.  
인터페이스 분리 원칙은 클라이언트 입장에서 인터페이스를 분리하고 있으며,  
의존 역전 원칙 역시 저수준 모듈을 사용하는 고수준 모듈 입장에서 추상화 타입을 도출하도록 유도한다.  
리스코프 치환 원칙은 사용자에게 기능 명세를 제공하고, 그 명세에 따라 기능을 구현할 것을 약속한다.   
이처럼 SOLID 원칙은 사용자 관점에서의 설계를 지향하고 있다.  
