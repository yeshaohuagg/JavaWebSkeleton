package cn.sinjinsong.skeleton.domain.dto.mail;


import cn.sinjinsong.skeleton.enumeration.mail.SendMode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by SinjinSong on 2017/5/5.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MailDTO {
    private List<Long> receivers;
    @NotNull
    private String text;
    @NotNull
    private SendMode sendMode;
}
