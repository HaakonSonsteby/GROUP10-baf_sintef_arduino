package no.ntnu.osnap.com;


public class ProtocolInstruction {
	private static final byte START_BYTE = (byte)0xFF;
	
	private byte opcode;
	private byte flag;
	private byte[] content;
	
	private boolean response;
	
	public ProtocolInstruction(byte opcode, byte flag, byte[] content){
		this.opcode = opcode;
		this.flag = flag;
		this.content = content;
		response = false;
	}
	
	public ProtocolInstruction(byte opcode, byte flag, byte[] content, boolean response){
		this.opcode = opcode;
		this.flag = flag;
		this.content = content;
		this.response = response;
	}
	
	public byte[] getInstructionBytes(){
		int size = content.length + 3;
		
		byte[] instruction = new byte[size + 1];
		
		instruction[0] = START_BYTE;
		instruction[1] = (byte)size;
		instruction[2] = opcode;
		instruction[3] = flag;
		
		for (int i = 4; i < size + 1; ++i){
			instruction[i] = content[i - 4];
		}
		
		return instruction;
	}
	
	public byte getOpcode(){
		return opcode;
	}
	
	public byte getFlag(){
		return flag;
	}
	
	public byte[] getContent(){
		return content;
	}
	
	public boolean hasResponse(){
		return response;
	}
}