package com.ra4king.opengl.arcsynthesis.gl32.chapter4.example1;

import java.nio.FloatBuffer;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.BufferUtils;

import com.ra4king.opengl.GLProgram;
import com.ra4king.opengl.util.ShaderProgram;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL15.*;
import static org.lwjgl.opengl.GL20.*;
import static org.lwjgl.opengl.GL30.*;

public class Example4_1 extends GLProgram {
	public static void main(String[] args) {
		new Example4_1().run(3,2);
	}
	
	private final float[] data = {
			 0.25f,  0.25f, 0.75f, 1.0f,
			 0.25f, -0.25f, 0.75f, 1.0f,
			-0.25f,  0.25f, 0.75f, 1.0f,
			
			 0.25f, -0.25f, 0.75f, 1.0f,
			-0.25f, -0.25f, 0.75f, 1.0f,
			-0.25f,  0.25f, 0.75f, 1.0f,
			
			 0.25f,  0.25f, -0.75f, 1.0f,
			-0.25f,  0.25f, -0.75f, 1.0f,
			 0.25f, -0.25f, -0.75f, 1.0f,
			
			 0.25f, -0.25f, -0.75f, 1.0f,
			-0.25f,  0.25f, -0.75f, 1.0f,
			-0.25f, -0.25f, -0.75f, 1.0f,
			
			-0.25f,  0.25f,  0.75f, 1.0f,
			-0.25f, -0.25f,  0.75f, 1.0f,
			-0.25f, -0.25f, -0.75f, 1.0f,
			
			-0.25f,  0.25f,  0.75f, 1.0f,
			-0.25f, -0.25f, -0.75f, 1.0f,
			-0.25f,  0.25f, -0.75f, 1.0f,
			
			 0.25f,  0.25f,  0.75f, 1.0f,
			 0.25f, -0.25f, -0.75f, 1.0f,
			 0.25f, -0.25f,  0.75f, 1.0f,
			 
			 0.25f,  0.25f,  0.75f, 1.0f,
			 0.25f,  0.25f, -0.75f, 1.0f,
			 0.25f, -0.25f, -0.75f, 1.0f,
			 
			 0.25f,  0.25f, -0.75f, 1.0f,
			 0.25f,  0.25f,  0.75f, 1.0f,
			-0.25f,  0.25f,  0.75f, 1.0f,
			
			 0.25f,  0.25f, -0.75f, 1.0f,
			-0.25f,  0.25f,  0.75f, 1.0f,
			-0.25f,  0.25f, -0.75f, 1.0f,
			
			 0.25f, -0.25f, -0.75f, 1.0f,
			-0.25f, -0.25f,  0.75f, 1.0f,
			 0.25f, -0.25f,  0.75f, 1.0f,
			 
			 0.25f, -0.25f, -0.75f, 1.0f,
			-0.25f, -0.25f, -0.75f, 1.0f,
			-0.25f, -0.25f,  0.75f, 1.0f,
			
			0.0f, 0.0f, 1.0f, 1.0f,
			0.0f, 0.0f, 1.0f, 1.0f,
			0.0f, 0.0f, 1.0f, 1.0f,
			
			0.0f, 0.0f, 1.0f, 1.0f,
			0.0f, 0.0f, 1.0f, 1.0f,
			0.0f, 0.0f, 1.0f, 1.0f,
			
			0.8f, 0.8f, 0.8f, 1.0f,
			0.8f, 0.8f, 0.8f, 1.0f,
			0.8f, 0.8f, 0.8f, 1.0f,
			
			0.8f, 0.8f, 0.8f, 1.0f,
			0.8f, 0.8f, 0.8f, 1.0f,
			0.8f, 0.8f, 0.8f, 1.0f,
			
			0.0f, 1.0f, 0.0f, 1.0f,
			0.0f, 1.0f, 0.0f, 1.0f,
			0.0f, 1.0f, 0.0f, 1.0f,
			
			0.0f, 1.0f, 0.0f, 1.0f,
			0.0f, 1.0f, 0.0f, 1.0f,
			0.0f, 1.0f, 0.0f, 1.0f,
			
			0.5f, 0.5f, 0.0f, 1.0f,
			0.5f, 0.5f, 0.0f, 1.0f,
			0.5f, 0.5f, 0.0f, 1.0f,
			
			0.5f, 0.5f, 0.0f, 1.0f,
			0.5f, 0.5f, 0.0f, 1.0f,
			0.5f, 0.5f, 0.0f, 1.0f,
			
			1.0f, 0.0f, 0.0f, 1.0f,
			1.0f, 0.0f, 0.0f, 1.0f,
			1.0f, 0.0f, 0.0f, 1.0f,
			
			1.0f, 0.0f, 0.0f, 1.0f,
			1.0f, 0.0f, 0.0f, 1.0f,
			1.0f, 0.0f, 0.0f, 1.0f,
			
			0.0f, 1.0f, 1.0f, 1.0f,
			0.0f, 1.0f, 1.0f, 1.0f,
			0.0f, 1.0f, 1.0f, 1.0f,
			
			0.0f, 1.0f, 1.0f, 1.0f,
			0.0f, 1.0f, 1.0f, 1.0f,
			0.0f, 1.0f, 1.0f, 1.0f
	};
	
	private ShaderProgram program;
	private int offsetUniform;
	
	private int vbo;
	
	public Example4_1() {
		super("Example 4.1", 500, 500, false);
	}
	
	@Override
	public void init() {
		glClearColor(0, 0, 0, 0);
		
		Map<Integer,String> attributes = new HashMap<Integer,String>();
		attributes.put(0, "position");
		attributes.put(1, "color");
		program = new ShaderProgram(readFromFile("example4.1.vert"),readFromFile("example4.1.frag"),attributes);
		
		offsetUniform = glGetUniformLocation(program.getProgram(), "offset");
		
		vbo = glGenBuffers();
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glBufferData(GL_ARRAY_BUFFER, (FloatBuffer)BufferUtils.createFloatBuffer(data.length).put(data).flip(), GL_STATIC_DRAW);
		
		glBindVertexArray(glGenVertexArrays());
		
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		
		glEnable(GL_CULL_FACE);
		glCullFace(GL_BACK);
		glFrontFace(GL_CW);
	}
	
	@Override
	public void render() {
		glClear(GL_COLOR_BUFFER_BIT);
		
		program.begin();
		
		glUniform2f(offsetUniform, 0.5f, 0.25f);
		
		glBindBuffer(GL_ARRAY_BUFFER, vbo);
		glEnableVertexAttribArray(0);
		glEnableVertexAttribArray(1);
		glVertexAttribPointer(0, 4, GL_FLOAT, false, 0, 0);
		glVertexAttribPointer(1, 4, GL_FLOAT, false, 0, data.length * 2);
		
		glDrawArrays(GL_TRIANGLES, 0, 36);
		
		glDisableVertexAttribArray(0);
		glDisableVertexAttribArray(1);
		glBindBuffer(GL_ARRAY_BUFFER, 0);
		
		program.end();
	}
}