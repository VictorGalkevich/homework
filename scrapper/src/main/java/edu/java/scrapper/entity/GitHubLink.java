package edu.java.scrapper.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class GitHubLink extends Link {
    private String defaultBranch;
    private Long forksCount;
}
