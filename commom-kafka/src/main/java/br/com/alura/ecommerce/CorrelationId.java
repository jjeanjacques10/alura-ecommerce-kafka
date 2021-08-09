package br.com.alura.ecommerce;

import java.util.UUID;

public class CorrelationId {

    private final String id;

    public CorrelationId(String title) {
        this.id = title + "(" + UUID.randomUUID() + ")";
    }

    @Override
    public String toString() {
        return "CorrelationId{" +
                "id='" + id + '\'' +
                '}';
    }

    public CorrelationId continueWith(CorrelationId title) {
        return new CorrelationId(id + "-" + title);
    }
}
