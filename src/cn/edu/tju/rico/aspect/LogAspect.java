package cn.edu.tju.rico.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Around("execution(* cn.edu.tju.rico.service.impl.UserServiceImpl.*(..))")
	public Object printLog(ProceedingJoinPoint jp) throws Throwable {
		System.out.println("��ʼ��¼��־...");
		
		// ��ȡĿ�귽���Ĳ���
		Object[] args = jp.getArgs();
		
		// ��ȡĿ�귽���ķ���ֵ
		Object rvt = jp.proceed(args);
		
		//��ӡϵͳִ����Ϣ�� Ŀ�����+Ŀ�귽��
		System.out.println("ϵͳ����ִ�з����� " + jp.getTarget().getClass().getName()
				+ "." + jp.getSignature().getName());
		System.out.println("��־��¼���... ");
		
		return rvt;
	}
}
