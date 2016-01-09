package com.vladmihalcea.book.hpjp.hibernate.identifier.optimizer.providers;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * <code>Sequence5PostEntityProvider</code> - Sequence 5 PostEntityProvider
 *
 * @author Vlad Mihalcea
 */
public class Sequence5PostEntityProvider extends PostEntityProvider<Sequence5PostEntityProvider.Post> {

    public Sequence5PostEntityProvider() {
        super(Post.class);
    }

    @Override
    public Post newPost() {
        return new Post();
    }

    @Entity(name = "Post")
    @Table(name = "post")
    public static class Post {

        @Id
        @GenericGenerator(name = "table", strategy = "enhanced-sequence", parameters = {
                @org.hibernate.annotations.Parameter(name = "table_name", value = "sequence_table"),
                @org.hibernate.annotations.Parameter(name = "increment_size", value = "5"),
                @org.hibernate.annotations.Parameter(name = "optimizer", value = "pooled"),
        })
        @GeneratedValue(generator = "table", strategy=GenerationType.TABLE)
        private Long id;
    }
}