package cn.edu.tju.rico.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

  
/**        
 * Title: LogAspect.java    
 * Description: �ڿ���̨��ӡ��־��������
 * @author rico       
 * @created 2017��4��24�� ����9:10:52    
 */      
@Component  // ��Spring������Aspect��
@Aspect		// ����������һ������
public class LogAspect {

	// Around Advice:�����޸�Ŀ�귽���Ĳ���������ֵ
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
		
		return rvt;   // ��Ŀ�귽���ķ���ֵ�����κδ���㷵��
	}
}
