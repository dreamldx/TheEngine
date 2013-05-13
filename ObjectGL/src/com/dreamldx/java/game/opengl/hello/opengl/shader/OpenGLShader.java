package com.dreamldx.java.game.opengl.hello.opengl.shader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import javax.media.opengl.GL2;

import com.dreamldx.java.game.opengl.hello.opengl.OpenGL;

public abstract class OpenGLShader {
	
	protected int id = 0;
	
	protected void load(int type, String program) {
		String[] programs = {program};
		int[] lengths = {program.length() };
		
		load(type, programs, lengths);
	}
	
	protected void load(int type, String[] programs, int[] lengths) {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		id = gl.glCreateShader(type);
		
		gl.glShaderSource(id, programs.length, programs, lengths, 0);
		gl.glCompileShader(id);
		
		printCompileError();
	}
	
	private void printCompileError() {
		GL2 gl = OpenGL.INSTANCE.getGL().getGL2();
		IntBuffer status = IntBuffer.allocate(1);
		gl.glGetShaderiv(id,GL2.GL_COMPILE_STATUS, status);
		
//		System.out.println("Compile Status " + status.get());
	}
	
	public void loadFile(String filename) throws FileNotFoundException, IOException {
		loadStream(new FileInputStream(filename));
	}
	
	public void loadURL(URL url) throws IOException {
		loadStream((FileInputStream) url.openStream());
	}
	
	public void loadStream(FileInputStream in) throws IOException {

		FileChannel channel = in.getChannel();
		long size = channel.size();
		
		ByteBuffer buffer = ByteBuffer.allocate((int) size);
		
		channel.read(buffer);
		channel.close();
		in.close();
		
		buffer.position(0);
		
		Charset uft8 = Charset.forName("UTF-8");
		CharBuffer charBuf = uft8.newDecoder().decode(buffer);
		
		load(charBuf.toString());
	}
	
	public abstract void load(String shader);
}
