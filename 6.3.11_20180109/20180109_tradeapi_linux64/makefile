OBJS=thosttraderapi_wrap.o
INCLUDE=-I./ -I${JAVA_HOME}/include -I${JAVA_HOME}/include/linux
TARGET=libthosttraderapi_wrap.so
CPPFLAG=-shared -fPIC
CC=g++
LDLIB=-L. -lthosttraderapi
$(TARGET) : $(OBJS)
	$(CC) $(CPPFLAG) $(INCLUDE) -o $(TARGET) $(OBJS) $(LDLIB) ./libiconv.a                                                                              
$(OBJS) : %.o : %.cpp
	$(CC) -c -fPIC $(INCLUDE) $< -o $@ 
clean:
	-rm -f $(OBJS)
	-rm -f $(TARGET)
install:
	cp $(TARGET) /usr/lib
