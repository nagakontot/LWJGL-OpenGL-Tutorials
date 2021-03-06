package com.ra4king.opengl.redbook.chapter2;

import static org.lwjgl.opengl.GL11.*;

import java.nio.ByteBuffer;

import org.lwjgl.BufferUtils;

import com.ra4king.opengl.GLProgram;

public class Example2_2 extends GLProgram {
	public static void main(String[] args) {
		new Example2_2().run();
	}
	
	private ByteBuffer fly = (ByteBuffer)BufferUtils.createByteBuffer(8 * 16).put(new byte[] {
			(byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00, (byte)0x00,
			(byte)0x03, (byte)0x80, (byte)0x01, (byte)0xC0, (byte)0x06, (byte)0xC0, (byte)0x03, (byte)0x60,
			(byte)0x04, (byte)0x60, (byte)0x06, (byte)0x20, (byte)0x04, (byte)0x30, (byte)0x0C, (byte)0x20,
			(byte)0x04, (byte)0x18, (byte)0x18, (byte)0x20, (byte)0x04, (byte)0x0C, (byte)0x30, (byte)0x20,
			(byte)0x04, (byte)0x06, (byte)0x60, (byte)0x20, (byte)0x44, (byte)0x03, (byte)0xC0, (byte)0x22,
			(byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22, (byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22,
			(byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22, (byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22,
			(byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22, (byte)0x44, (byte)0x01, (byte)0x80, (byte)0x22,
			(byte)0x66, (byte)0x01, (byte)0x80, (byte)0x66, (byte)0x33, (byte)0x01, (byte)0x80, (byte)0xCC,
			(byte)0x19, (byte)0x81, (byte)0x81, (byte)0x98, (byte)0x0C, (byte)0xC1, (byte)0x83, (byte)0x30,
			(byte)0x07, (byte)0xe1, (byte)0x87, (byte)0xe0, (byte)0x03, (byte)0x3f, (byte)0xfc, (byte)0xc0,
			(byte)0x03, (byte)0x31, (byte)0x8c, (byte)0xc0, (byte)0x03, (byte)0x33, (byte)0xcc, (byte)0xc0,
			(byte)0x06, (byte)0x64, (byte)0x26, (byte)0x60, (byte)0x0c, (byte)0xcc, (byte)0x33, (byte)0x30,
			(byte)0x18, (byte)0xcc, (byte)0x33, (byte)0x18, (byte)0x10, (byte)0xc4, (byte)0x23, (byte)0x08,
			(byte)0x10, (byte)0x63, (byte)0xC6, (byte)0x08, (byte)0x10, (byte)0x30, (byte)0x0c, (byte)0x08,
			(byte)0x10, (byte)0x18, (byte)0x18, (byte)0x08, (byte)0x10, (byte)0x00, (byte)0x00, (byte)0x08
	}).flip();
	
	private ByteBuffer halftone = (ByteBuffer)BufferUtils.createByteBuffer(8 * 16).put(new byte[] {
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
			(byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0xAA, (byte)0x55, (byte)0x55, (byte)0x55, (byte)0x55,
	}).flip();
	
	public Example2_2() {
		super("Example 2.1", 350, 150, false);
	}
	
	@Override
	public void init() {
		glOrtho(0, getWidth(), 0, getHeight(), -1, 1);
		
		glClearColor(0, 0, 0, 0);
		glColor3f(1, 1, 1);
		
		glShadeModel(GL_FLAT);
	}
	
	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		glRectf(25, 25, 125, 125);
		glEnable(GL_POLYGON_STIPPLE);
		glPolygonStipple(fly);
		glRectf(125, 25, 225, 125);
		glPolygonStipple(halftone);
		glRectf(225, 25, 325, 125);
		glDisable(GL_POLYGON_STIPPLE);
	}
}
