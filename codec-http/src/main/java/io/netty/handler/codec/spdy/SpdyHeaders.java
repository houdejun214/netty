/*
 * Copyright 2013 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.spdy;

import io.netty.handler.codec.Headers;
import io.netty.util.AsciiString;

import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

/**
 * Provides the constants for the standard SPDY HTTP header names and commonly
 * used utility methods that access a {@link SpdyHeadersFrame}.
 */
public interface SpdyHeaders extends Headers<CharSequence> {

    /**
     * SPDY HTTP header names
     */
    final class HttpNames {
        /**
         * {@code ":host"}
         */
        public static final AsciiString HOST = new AsciiString(":host");
        /**
         * {@code ":method"}
         */
        public static final AsciiString METHOD = new AsciiString(":method");
        /**
         * {@code ":path"}
         */
        public static final AsciiString PATH = new AsciiString(":path");
        /**
         * {@code ":scheme"}
         */
        public static final AsciiString SCHEME = new AsciiString(":scheme");
        /**
         * {@code ":status"}
         */
        public static final AsciiString STATUS = new AsciiString(":status");
        /**
         * {@code ":version"}
         */
        public static final AsciiString VERSION = new AsciiString(":version");

        private HttpNames() { }
    }

    @Override
    SpdyHeaders add(CharSequence name, CharSequence value);

    @Override
    SpdyHeaders add(CharSequence name, Iterable<? extends CharSequence> values);

    @Override
    SpdyHeaders add(CharSequence name, CharSequence... values);

    @Override
    SpdyHeaders addObject(CharSequence name, Object value);

    @Override
    SpdyHeaders addObject(CharSequence name, Iterable<?> values);

    @Override
    SpdyHeaders addObject(CharSequence name, Object... values);

    @Override
    SpdyHeaders addBoolean(CharSequence name, boolean value);

    @Override
    SpdyHeaders addByte(CharSequence name, byte value);

    @Override
    SpdyHeaders addChar(CharSequence name, char value);

    @Override
    SpdyHeaders addShort(CharSequence name, short value);

    @Override
    SpdyHeaders addInt(CharSequence name, int value);

    @Override
    SpdyHeaders addLong(CharSequence name, long value);

    @Override
    SpdyHeaders addFloat(CharSequence name, float value);

    @Override
    SpdyHeaders addDouble(CharSequence name, double value);

    @Override
    SpdyHeaders addTimeMillis(CharSequence name, long value);

    @Override
    SpdyHeaders add(Headers<? extends CharSequence> headers);

    @Override
    SpdyHeaders set(CharSequence name, CharSequence value);

    @Override
    SpdyHeaders set(CharSequence name, Iterable<? extends CharSequence> values);

    @Override
    SpdyHeaders set(CharSequence name, CharSequence... values);

    @Override
    SpdyHeaders setBoolean(CharSequence name, boolean value);

    @Override
    SpdyHeaders setByte(CharSequence name, byte value);

    @Override
    SpdyHeaders setChar(CharSequence name, char value);

    @Override
    SpdyHeaders setShort(CharSequence name, short value);

    @Override
    SpdyHeaders setInt(CharSequence name, int value);

    @Override
    SpdyHeaders setLong(CharSequence name, long value);

    @Override
    SpdyHeaders setFloat(CharSequence name, float value);

    @Override
    SpdyHeaders setDouble(CharSequence name, double value);

    @Override
    SpdyHeaders setTimeMillis(CharSequence name, long value);

    @Override
    SpdyHeaders setObject(CharSequence name, Object value);

    @Override
    SpdyHeaders setObject(CharSequence name, Iterable<?> values);

    @Override
    SpdyHeaders setObject(CharSequence name, Object... values);

    @Override
    SpdyHeaders set(Headers<? extends CharSequence> headers);

    @Override
    SpdyHeaders setAll(Headers<? extends CharSequence> headers);

    @Override
    SpdyHeaders clear();

    /**
     * {@link Headers#get(Object)} and convert the result to a {@link String}.
     * @param name the name of the header to retrieve
     * @return the first header value if the header is found. {@code null} if there's no such header.
     */
    String getAsString(CharSequence name);

    /**
     * {@link Headers#getAll(Object)} and convert each element of {@link List} to a {@link String}.
     * @param name the name of the header to retrieve
     * @return a {@link List} of header values or an empty {@link List} if no values are found.
     */
    List<String> getAllAsString(CharSequence name);

    /**
     * {@link #iterator()} that converts each {@link Entry}'s key and value to a {@link String}.
     */
    Iterator<Entry<String, String>> iteratorAsString();

    /**
     * Returns {@code true} if a header with the {@code name} and {@code value} exists, {@code false} otherwise.
     * <p>
     * If {@code ignoreCase} is {@code true} then a case insensitive compare is done on the value.
     * @param name the name of the header to find
     * @param value the value of the header to find
     * @param ignoreCase {@code true} then a case insensitive compare is run to compare values.
     * otherwise a case sensitive compare is run to compare values.
     */
    boolean contains(CharSequence name, CharSequence value, boolean ignoreCase);
}
