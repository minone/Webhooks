package br.com.minone.webhooks.infrastructure.amqp;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;

import com.rabbitmq.client.Channel;

import br.com.minone.webhooks.infrastructure.service.IncredibleHookService;

public class RabbitMQMessageListener implements ChannelAwareMessageListener {

	private final IncredibleHookService incredibleHookService;

	public RabbitMQMessageListener() {
		this.incredibleHookService = IncredibleHookService.newInstance();
	}

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		
		String url = message.getMessageProperties().getReplyTo();
		
		String content = new String(message.getBody());
		
		String contentType = message.getMessageProperties().getContentType();
		
		boolean success = incredibleHookService.deliver(url, content, contentType);
		
		if (!success) {
			channel.basicReject(message.getMessageProperties().getDeliveryTag(), true);
		}

	}
}
