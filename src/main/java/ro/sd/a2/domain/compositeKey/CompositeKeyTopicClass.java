package ro.sd.a2.domain.compositeKey;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompositeKeyTopicClass implements Serializable {

  @NotNull
  private String topicId;

  @NotNull
  private String classId;

}
