package i.vk.inders;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpPacket {
	private String expCode;
	private String expMsg;
	private LocalDateTime occuredOn;
}
