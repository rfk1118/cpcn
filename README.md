# cpcn
接入中金


``` 
.
├── lib
│   ├── InstitutionTools-v1.0.0.1.jar  // 中金源码文件
│   └── cpcn-payment-api-2.4.5.3.jar // 中金源码文件
├── main
│   ├── java
│   │   └── com
│   │       └── renfakai
│   │           └── cpcn
│   │               ├── CpcnApplication.java  // SpringbootApplication
│   │               ├── annotation            // annotation
│   │               │   ├── CpcnHandlerType.java  // 中金请求管理器注解
│   │               │   └── CpcnNoticeHandlerType.java // 中金回调管理器注解
│   │               ├── conf
│   │               │   └── Configuration.java  // 配置文件管理器
│   │               ├── dict
│   │               │   ├── CpcnConstant.java  // 常量
│   │               │   ├── CpcnNoticeType.java // 中金回调策略，枚举
│   │               │   └── CpcnRequestType.java // 中金请求策略，枚举
│   │               ├── dto
│   │               │   └── CpcnNoticeRequest.java  // 中金回调信息
│   │               ├── notice
│   │               │   ├── CpcnNoticeManager.java // 中金回调管理器
│   │               │   ├── service
│   │               │   │   ├── CpcnNoticeService.java // 中金回调门面接口
│   │               │   │   └── impl
│   │               │   │       └── CpcnNoticeServiceImpl.java // 中金回调门面管理，设计模式
│   │               │   ├── strategy
│   │               │   │   ├── AbstractCpcnNoticeService.java // 中金回调策略
│   │               │   │   └── impl
│   │               │   │       ├── NilCpcnNoticeService.java // impl
│   │               │   │       ├── Notice2018RequestStrategy.java // impl
│   │               │   │       └── Notice2818RequestStrategy.java // impl
│   │               │   └── wrap
│   │               │       └── CpcnNoticeWrapper.java // wrap something 
│   │               ├── policy
│   │               │   ├── AbstractCpcnPayService.java  // 主动接口抽象
│   │               │   ├── PolicyManager.java  // 管理器
│   │               │   └── impl
│   │               │       ├── Tx1610RequestPolicy.java // impl
│   │               │       ├── Tx1620RequestPolicy.java
│   │               │       ├── Tx2011RequestPolicy.java
│   │               │       ├── Tx2020RequestPolicy.java
│   │               │       ├── Tx2320RequestPolicy.java
│   │               │       ├── Tx2340RequestPolicy.java
│   │               │       ├── Tx2531RequestPolicy.java
│   │               │       ├── Tx2532RequestPolicy.java
│   │               │       ├── Tx2811RequestPolicy.java
│   │               │       ├── Tx2813RequestPolicy.java
│   │               │       ├── Tx2814RequestPolicy.java
│   │               │       ├── Tx2820RequestPolicy.java
│   │               │       ├── Tx2841RequestPolicy.java
│   │               │       ├── Tx2911RequestPolicy.java
│   │               │       ├── Tx4510RequestPolicy.java
│   │               │       ├── Tx4530RequestPolicy.java
│   │               │       └── Tx4532RequestPolicy.java // impl
│   │               ├── replace
│   │               │   ├── CpcnRedefine.java // byte buddy loading
│   │               │   ├── base
│   │               │   │   └── TxBaseRequestRedefine.java // 替换TxBaseRequest
│   │               │   ├── context
│   │               │   │   ├── CpcnSignatureFactoryContext.java // like ApplicationContext SignatureFactory容器
│   │               │   │   └── MerchantContext.java  // ThreadLocal 传递参数
│   │               │   ├── security
│   │               │   │   └── SignatureFactoryReplace.java // SignatureFactory 重新定义
│   │               │   └── system
│   │               │       └── PaymentSignatureFactoryEnvironmentInit.java // init SignatureFactoryBean into CpcnSignatureFactoryContext
│   │               └── web
│   │                   └── CpcnNoticeController.java  // web controller
│   └── resources
│       ├── application.properties
│       ├── conf
│       │   └── cpcn
│       │       ├── cmb.ini
│       │       ├── common.ini
│       │       ├── crossborder.ini
│       │       ├── gateway4file.ini
│       │       ├── payment.ini
│       │       ├── paymentuser.ini
│       │       ├── paytest.cer
│       │       ├── test.pfx
│       │       ├── tianjin
│       │       │   └── fbtj02.pfx
│       │       └── trust.jks
│       └── cpcn.properties
└── test
    └── java
        └── com
            └── renfakai
                └── cpcn
                    └── CpcnApplicationTests.java

33 directories, 57 files

```
