# Proxy Pattern（代理模式）

* 为其他对象提供一种代理以控制对这个对象的访问。

## 使用场景

* 就是一个人或者机构代表另一个人或者机构采取行动。在一些情况下，一个客户不想或者不能够直接引用一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。

## UML类图

![proxy](proxy-uml.png)

## 代码

```
interface Subject {
    fun buyMac()
}

class RealSubject : Subject {
    override fun buyMac() {
        println("买一台MAC")
    }
}

class MyProxy : Subject {
    override fun buyMac() {
        val subject = RealSubject()
        subject.buyMac()
        wrapMac()
    }

    private fun wrapMac() {
        println("用盒子包装好Mac")
    }
}

fun proxyDemo() {
    val subject = MyProxy()
    subject.buyMac()
}
```
## android源码中的模式实现 

```
Binder

public interface IBank extends IInterface {

   static final String DESCRIPTOR = "com.ryg.design.manualbinder.IBank";

   static final int TRANSACTION_queryMoney = (IBinder.FIRST_CALL_TRANSACTION + 0);

   public long queryMoney(int uid) throws RemoteException;

}

public class BankImpl extends Binder implements IBank {

    public BankImpl() {
        this.attachInterface(this, DESCRIPTOR);
    }

    public static IBank asInterface(IBinder obj) {
        if ((obj == null)) {
            return null;
        }
        android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
        if (((iin != null) && (iin instanceof IBank))) {
            return ((IBank) iin);
        }
        return new BankImpl.Proxy(obj);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }

    @Override
    public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
            throws RemoteException {
        switch (code) {
        case INTERFACE_TRANSACTION: {
            reply.writeString(DESCRIPTOR);
            return true;
        }
        case TRANSACTION_queryMoney: {
            data.enforceInterface(DESCRIPTOR);
            int uid = data.readInt();
            long result = this.queryMoney(uid);
            reply.writeNoException();
            reply.writeLong(result);
            return true;
        }
        }
        return super.onTransact(code, data, reply, flags);
    }

    @Override
    public long queryMoney(int uid) throws RemoteException {
        return uid * 10l;
    }

    private static class Proxy implements IBank {
        private IBinder mRemote;

        Proxy(IBinder remote) {
            mRemote = remote;
        }

        @Override
        public IBinder asBinder() {
            return mRemote;
        }

        public java.lang.String getInterfaceDescriptor() {
            return DESCRIPTOR;
        }

        @Override
        public long queryMoney(int uid) throws RemoteException {
            Parcel data = Parcel.obtain();
            Parcel reply = Parcel.obtain();
            long result;
            try {
                data.writeInterfaceToken(DESCRIPTOR);
                data.writeInt(uid);
                mRemote.transact(TRANSACTION_queryMoney, data, reply, 0);
                reply.readException();
                result = reply.readLong();
            } finally {
                reply.recycle();
                data.recycle();
            }
            return result;
        }

    }

}
```

## 优点与缺点

### 优点

* 代理对象可以在客户端和目标对象之间起到中介的作用，这样起到了中介的作用和保护了目标对象的作用。
* 给对象增加了本地化的扩展性，增加了存取操作控制。

### 缺点

* 会产生多余的代理类

## [更多](https://github.com/simple-android-framework/android_design_patterns_analysis/tree/master/proxy/singwhatiwanna)