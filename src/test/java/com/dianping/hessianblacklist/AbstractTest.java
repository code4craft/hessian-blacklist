package com.dianping.hessianblacklist;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author code4crafer@gmail.com
 */
public abstract class AbstractTest {

    protected <T> T goThroughHessian(T origin) throws IOException {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        Hessian2Output hessian2Output = new Hessian2Output(byteOutputStream);
        hessian2Output.writeObject(origin);
        hessian2Output.close();
        byte[] bytes = byteOutputStream.toByteArray();
        Hessian2Input hessian2Input = new Hessian2Input(new ByteArrayInputStream(bytes));
        Object object = hessian2Input.readObject();
        return (T) object;
    }

}
