package com.dianping.hessianblacklist.guava;

import com.dianping.hessianblacklist.AbstractTest;
import com.google.common.collect.*;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * MultiMap测试结果：序列化/反序列化之后新对象存在，内容为空。
 *
 * @author code4crafer@gmail.com
 */
public class MultiMapTest extends AbstractTest {

    private void testAndAssertMultiMap(Multimap<String, String> originMap) throws IOException {
        originMap.put("foo", "foo1");
        originMap.put("foo", "foo2");
        Multimap<String, String> newMap = goThroughHessian(originMap);
        //序列化/反序列化之后新对象存在，内容为空。
        assertThat(newMap).isNotNull();
        assertThat(newMap.get("foo")).isEmpty();
    }

    @Test
    public void testArrayListMultiMap() throws Exception {
        testAndAssertMultiMap(ArrayListMultimap.<String, String>create());
    }

    @Test
    public void testLinkedListMultiMap() throws Exception {
        testAndAssertMultiMap(LinkedListMultimap.<String, String>create());
    }

    @Test
    public void testHashSetMultiMap() throws Exception {
        testAndAssertMultiMap(HashMultimap.<String, String>create());
    }
}
