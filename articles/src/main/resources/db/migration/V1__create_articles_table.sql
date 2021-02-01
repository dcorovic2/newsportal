CREATE TABLE articles (
    id UUID PRIMARY KEY,
    title VARCHAR NOT NULL,
    content VARCHAR NOT NULL,
    created_by UUID NOT NULL,
    edited_by UUID NOT NULL,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

