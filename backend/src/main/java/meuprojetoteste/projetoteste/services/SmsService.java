package meuprojetoteste.projetoteste.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import meuprojetoteste.projetoteste.entities.Sales;
import meuprojetoteste.projetoteste.repositories.SalesRepository;

@Service
public class SmsService {

	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;

	@Autowired
	private SalesRepository salesRepository;

	public void sendSms(Long saleId) {

		Sales sales = salesRepository.findById(saleId).get();

		String date = sales.getDate().getMonthValue() + "/" + sales.getDate().getYear();

		String msg = "O Vendedor " + sales.getSellerName() + " foi destaque em " + date + " com um total de R$ "
				+ String.format("%.2f", sales.getAmount());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

		System.out.println(message.getSid());
	}
}