【流的分类】
1、流向：输入流与输出流
2、数据：字节流：二进制，一切文件,  每个字节直接写入到文件   。InputStream  OutputStream
        字符流：文本文件，只能处理纯文本,先写缓冲(*flush*),然后到文件  。Reader  Writer
3、功能：节点流：包裹源头(包括Reader、Writer、FileInputStream、FileOutputStream等)
        处理流:增强功能，提高性能

处理流:增强功能，提高性能，必须在节点流之上
一、缓冲流
1、字节缓冲流
 BufferedInputStream
 BufferedOutputStream
2、字符缓冲流
 BufferedReader readLine()
 BufferedWriter newLine()
【在使用时建议加上缓冲流，提高性能】


二、转换流：字节流转为字符流 处理乱码(编码集、解码集)
二进制到字符为解码，字符到二进制位编码
FileReader
FileWriter
InputStreamReader
OutputStreamWriter

Scanner
PrinterWriter
